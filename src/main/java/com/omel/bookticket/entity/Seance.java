
package com.omel.bookticket.entity;

import java.io.Serializable;
import java.util.Objects;


/**
 *
 * @author Katya Omelyashchik
 */
public class Seance implements Serializable{
    
    private long id;
    private String date;
    private String time;
    private String name;
    private int freePlaces;

    public Seance() {
    }

    public Seance(long id, String date, String time, String name, int freePlaces) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.name = name;
        this.freePlaces = freePlaces;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(int freePlaces) {
        this.freePlaces = freePlaces;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 83 * hash + Objects.hashCode(this.date);
        hash = 83 * hash + Objects.hashCode(this.time);
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + this.freePlaces;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Seance other = (Seance) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.freePlaces != other.freePlaces) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Seance{" + "id=" + id + ", date=" + date + ", time=" + time + ","
                + " name=" + name + ", freePlaces=" + freePlaces + '}';
    }
    
    
    
}
