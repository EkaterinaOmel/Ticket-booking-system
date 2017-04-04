
package com.omel.bookticket.dao;

import java.util.List;

/**
 *
 * @author Katya Omelyashchik
 * @param <T>
 */
public interface Dao <T> {
   
    void create(T t);
    List <T> readAll();   
    T readById(long id); 
    void update(T t);
    void delete(T t);
}
