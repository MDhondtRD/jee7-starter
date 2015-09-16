package com.realdolmen.exercise;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne
    private Flight outFlight;

    @ManyToOne
    private Flight returnFlight;




    // CONSTRUCTORS

    public Ticket() {
        // required no-argument constructor
    }

    public Ticket(Double price) {
        this.price = price;
        this.status = Status.PENDING;
        this.outFlight = null;
        this.returnFlight = null;
    }




    // GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Flight getOutFlight() {
        return outFlight;
    }

    public void setOutFlight(Flight outFlight) {
        this.outFlight = outFlight;
    }

    public Flight getReturnFlight() {
        return returnFlight;
    }

    public void setReturnFlight(Flight returnFlight) {
        this.returnFlight = returnFlight;
    }
}
