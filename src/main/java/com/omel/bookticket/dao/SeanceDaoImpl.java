
package com.omel.bookticket.dao;

import com.omel.bookticket.entity.Seance;
import com.omel.bookticket.file.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Katya Omelyashchik
 */
public class SeanceDaoImpl extends DaoImpl<Seance>{

     private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(OrderDaoImpl.class);
     
    public SeanceDaoImpl(File file) {
        super(file);
    }

    @Override
    public Seance readById(long id) {
        List<Seance> list = readAll();
        for (Seance lst : list) {
            if (lst.getId() == id) {
                return lst;
            }
        }
        return null;
    }

    @Override
    public void update(Seance t) {
        List<Seance> list = readAll();
        for (Seance lst : list) {
            if (lst.getId() == t.getId()) {
                list.remove(lst);
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
