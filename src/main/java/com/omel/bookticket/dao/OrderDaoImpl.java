
package com.omel.bookticket.dao;

import com.omel.bookticket.entity.Order;
import com.omel.bookticket.file.File;
import java.io.IOException;

import java.util.List;

/**
 *
 * @author Katya Omelyashchik
 */
public class OrderDaoImpl extends DaoImpl<Order> {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(OrderDaoImpl.class);
    
    public OrderDaoImpl(File file) {
        super(file);
    }

    @Override
    public Order readById(long id) {
        List<Order> list = readAll();
        for (Order order : list) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    @Override
    public void update(Order t) {
        List<Order> list = readAll();
        for (Order order : list) {
            if (order.getId() == t.getId()) {
                list.remove(order);
                list.add(t);
            }
        }
        try {
            out.writeObject(list);
            out.close();
        } catch (IOException ex) {
             log.error("Exception: " + ex.toString());
        }
    }

}
