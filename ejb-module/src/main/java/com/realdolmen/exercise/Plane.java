package com.realdolmen.exercise;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plane {

    // ATTRIBUTES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;




    // CONSTRUCTORS

    public Plane() {
        // required no-argument constructor
    }

    public Plane(String type) {
        this.type = type;
    }




    // GETTERS & SETTERS

    public String getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }
}
