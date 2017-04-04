
package com.omel.bookticket.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Katya Omelyashchik
 */
public class Order implements Serializable{
    
    private long id;
    private Seance seance;
    private int countTicket;

    public Order() {
    }

    public Order(long id, Seance seance, int countTicket) {
        this.id = id;
        this.seance = seance;
        this.countTicket = countTicket;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public int getCountTicket() {
        return countTicket;
    }

    public void setCountTicket(int countTicket) {
        this.countTicket = countTicket;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.seance);
        hash = 97 * hash + this.countTicket;
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
        final Order other = (Order) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.countTicket != other.countTicket) {
            return false;
        }
        if (!Objects.equals(this.seance, other.seance)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", seance=" + seance + ", countTicket=" + countTicket + '}';
    }
    
    

}