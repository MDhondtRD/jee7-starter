package com.realdolmen.exercise;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;




    // CONSTRUCTORS

    public Ticket() {
        // required no-argument constructor
    }

    public Ticket(Double price) {
        this.price = price;
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
}
