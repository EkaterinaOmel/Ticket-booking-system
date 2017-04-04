
package com.omel.bookticket.services;

import com.omel.bookticket.dao.DaoImpl;
import com.omel.bookticket.dao.Factory;
import com.omel.bookticket.entity.Order;
import com.omel.bookticket.entity.Seance;
import java.net.URI;
import java.util.Date;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author Katya Omelyashchik
 */
@Path("/orders")
@Produces({"application/json"})
public class OrderService {
   

    @POST
    @Path("/book")
    @Consumes({"application/json"})
    public Response find(@FormParam("idSeance") long idSeance,
            @FormParam("count") int countTicket) {
        if (idSeance == 0) {
             return Response.status(Response.Status.NOT_FOUND).build();
        }
        DaoImpl daoSean= Factory.getInstance().getDAO(new Seance());
        Seance sn = (Seance) daoSean.readById(idSeance);
        if (sn.getFreePlaces() < countTicket) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Date currentDate = new Date();
        long idBook = currentDate.getTime() + sn.getId();
        Order ord = new Order(idBook, sn, countTicket);
        DaoImpl daoOrd= Factory.getInstance().getDAO(ord);
        daoOrd.create(ord);
        sn.setFreePlaces(sn.getFreePlaces() - countTicket);
        daoSean.update(sn);
        URI location = URI.create("/book/" + idBook);
        return Response.created(location).build();
      

    }

    @POST
    @Path("/cancel")
    @Consumes({"application/json"})
    public Response cancel(@FormParam("idOrder") long idOrder) {

        DaoImpl daoOrd= Factory.getInstance().getDAO(new Order());
        Order ord = (Order) daoOrd.readById(idOrder);
        if (ord == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        daoOrd.delete(ord);
        DaoImpl daoSean= Factory.getInstance().getDAO(new Seance());
        Seance sn = (Seance) daoSean.readById(ord.getSeance().getId());
        sn.setFreePlaces(sn.getFreePlaces() + ord.getCountTicket());
        daoSean.update(sn);

        return Response.noContent().build();

    }
    

    @GET
    @Path("/{idOrder}")
    public Order get(@PathParam("idOrder") long id) {
        DaoImpl daoOrd= Factory.getInstance().getDAO(new Order());
        return (Order) daoOrd.readById(id);
    }

}
