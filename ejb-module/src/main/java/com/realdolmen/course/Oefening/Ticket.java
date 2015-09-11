package com.realdolmen.course.Oefening;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MDNAX30 on 10/09/2015.
 */
@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double price;
    @ManyToOne
    private Passenger passenger;
    @ManyToOne
    private Flight out;
    @ManyToOne
    private Flight returnFlight;

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Ticket(double price) {
        this.price = price;
    }

    public Ticket() {
    }

    public Flight getOut() {
        return out;
    }

    public void setOut(Flight out) {
        this.out = out;
    }

    public Flight getReturnFlight() {
        return returnFlight;
    }

    public void setReturnFlight(Flight returnFlight) {
        this.returnFlight = returnFlight;
    }

    public long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


