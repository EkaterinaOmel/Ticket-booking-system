
package com.omel.bookticket.dao;

import com.omel.bookticket.file.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Katya Omelyashchik
 * @param <T>
 */
public abstract class DaoImpl<T> implements Dao<T> {

    
    protected final File file;
    protected ObjectOutputStream out;
    protected ObjectInputStream in;
     private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DaoImpl.class);

    public DaoImpl(File file) {        
        this.file = file;

    }

    @Override
    public void create(T t) {
        List<T> list = readAll();
        list.add(t);
        try {
            out = file.openForWrite();
            out.writeObject(list);
            out.close();
        } catch (IOException ex) {
            log.error("Exception: " + ex.toString());
        }
        
      

    }

    @Override
    public List<T> readAll() {
        List<T> list = new ArrayList<>();
        try {
            in = file.openForRead();
            list = (ArrayList<T>) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException |NullPointerException ex) {
            log.error("Exception: " + ex.toString());
        }
       

        return list;
    }

    @Override
    public void delete(T t) {
        List<T> list = readAll();
        list.remove(t);
        try {
            out = file.openForWrite();
            out.writeObject(list);
            out.close();
        } catch (IOException ex) {
            log.error("Exception: " + ex.toString());
        } 
    }
}
