package com.omel.bookticket.dao;

import com.omel.bookticket.entity.Order;
import com.omel.bookticket.entity.Seance;
import com.omel.bookticket.file.File;

/**
 *
 * @author Katya Omelyashchik
 * @param <T>
 */
public class Factory<T> {

    private static DaoImpl order = null;
    private static DaoImpl seance = null;

    private static File file1;
    private static File file2;

    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
            file1 = new File("/seance.dat");
            file2 = new File("/order.dat");
        }
        return instance;
    }

    public DaoImpl getDAO(T t) {
        if (t.getClass() == Order.class) {
            if (order == null) {
                order = new OrderDaoImpl(file2);
            }
            return order;
        } else if (t.getClass() == Seance.class) {
            if (seance == null) {
                seance = new SeanceDaoImpl(file1);
            }
            return seance;
        }
        return null;

    }
}
