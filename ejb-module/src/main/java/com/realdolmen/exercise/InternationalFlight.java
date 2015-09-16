package com.realdolmen.exercise;

import javax.persistence.Entity;

@Entity
public class InternationalFlight extends Flight {

    // ATTRIBUTES

    private Boolean blacklisted;

    private String regulations;




    // CONSTRUCTORS

    public InternationalFlight() {
        // required no-argument constructor
    }

    public InternationalFlight(String number) {
        super(number);
    }




    // GETTERS & SETTERS

    public Boolean getBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(Boolean blacklisted) {
        this.blacklisted = blacklisted;
    }

    public String getRegulations() {
        return regulations;
    }

    public void setRegulations(String regulations) {
        this.regulations = regulations;
    }
}
