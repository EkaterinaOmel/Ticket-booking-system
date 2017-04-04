
package com.omel.bookticket.services;

import com.omel.bookticket.dao.DaoImpl;
import com.omel.bookticket.dao.Factory;
import com.omel.bookticket.entity.Seance;
import javax.ws.rs.*;
import java.util.List;

/**
 *
 * @author Katya Omelyashchik
 */
@Path("/seances")
@Produces({"application/json"})
public class SeanceService {

    @GET
    public List<Seance> getAll() {
        DaoImpl daoSean = Factory.getInstance().getDAO(new Seance());
        return daoSean.readAll();
    }

}
