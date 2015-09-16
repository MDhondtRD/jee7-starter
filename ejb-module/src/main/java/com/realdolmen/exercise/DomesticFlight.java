package com.realdolmen.exercise;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DomesticFlight extends Flight {

    // ATTRIBUTES

    private String airlineCompany;

    @ElementCollection
    private List<String> refs = new ArrayList<String>();




    // CONSTRUCTORS

    public DomesticFlight() {
        // required no-argument constructor
    }

    public DomesticFlight(String number) {
        super(number);
    }




    // GETTERS & SETTERS

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public List<String> getRefs() {
        ArrayList<String> list = new ArrayList<String>();
        for (String reference : refs)
            list.add(reference);
        return list;
    }




    // METHODS

    public void addReference(String r){
        if (r == null)
            throw new IllegalArgumentException("Null String is not allowed.");
        refs.add(r);
    }
}
