package com.realdolmen.exercise;

import javax.persistence.*;

@Entity
public class Airport {

    // ATTRIBUTES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;




    // CONSTRUCTORS

    public Airport() {
        // required no-argument constructor
    }

    public Airport(String code, String name) {
        if (code == null || name == null)
            throw new IllegalArgumentException("Airport code and name should not be NULL.");
        this.code = code;
        this.name = name;
    }




    // GETTERS & SETTERS

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
}
