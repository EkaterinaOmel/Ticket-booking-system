
package com.omel.bookticket.file;

import com.omel.bookticket.dao.OrderDaoImpl;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Katya Omelyashchik
 */
public class File {

    private final String nameFile;
    private ObjectOutputStream out = null;
    private ObjectInputStream in = null;
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(OrderDaoImpl.class);
     

    public File(String nameFile) {
        this.nameFile = nameFile;
    }

    public ObjectOutputStream openForWrite() {

        try {
            out = new ObjectOutputStream(new FileOutputStream(nameFile));
        } catch (IOException ex) {
            log.error("Exception: " + ex.toString());
        }
        return out;
    }

    public ObjectInputStream openForRead() {

        try {
            in = new ObjectInputStream(new FileInputStream(nameFile));
        } catch (IOException ex) {
            log.error("Exception: " + ex.toString());
        }
        return in;
    }

    public void closeForWrite() {
        try {
            out.close();
        } catch (IOException ex) {
            log.error("Exception: " + ex.toString());
        }

    }

    public void closeForRead() {
        try {
            in.close();
        } catch (IOException ex) {
            log.error("Exception: " + ex.toString());
        }
    }
}
