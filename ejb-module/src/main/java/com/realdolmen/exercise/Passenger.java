package com.realdolmen.exercise;

import javax.persistence.*;

@Entity
@NamedQuery(name = Passenger.FIND_ALL_PASSENGERS, query = "SELECT p FROM Passenger p")
@SecondaryTables({
        @SecondaryTable(name = "t_miles"),
        @SecondaryTable(name = "t_picture")
})
public class Passenger {

    // ATTRIBUTES

    public static final String FIND_ALL_PASSENGERS = "Passenger.findAllPassengers";

    @EmbeddedId
    private PassengerId id;

    private String firstName;

    @Column(table = "t_miles")
    private Integer frequentFlyerMiles;

    @Basic(fetch = FetchType.LAZY)
    @Column(table = "t_picture")
    @Lob
    private byte[] picture;




    // CONSTRUCTORS

    public Passenger(){
        // required no-argument constructor
    }

    public Passenger(String ssn){
        PassengerId pI = new PassengerId(ssn, "Doe");
        this.id = pI;
        setFirstName("John");
        setFrequentFlyerMiles(0);
    }

    public Passenger(String ssn, String firstName, String lastName){
        PassengerId pI = new PassengerId(ssn, lastName);
        this.id = pI;
        setFirstName(firstName);
        setFrequentFlyerMiles(0);
    }

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles){
        PassengerId pI = new PassengerId(ssn, lastName);
        this.id = pI;
        setFirstName(firstName);
        setFrequentFlyerMiles(frequentFlyerMiles);
    }




    // GETTERS & SETTERS

    public PassengerId getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        if (isValidMiles(frequentFlyerMiles))
            this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }




    // METHODS

    public void addFrequentFlyerMiles(Integer miles){
        if (isValidMiles(miles))
            this.frequentFlyerMiles += miles;
    }

    private boolean isValidMiles(Integer miles){
        if (miles == null || miles < 0)
            throw new IllegalArgumentException("Illegal frequent flyer miles.");
        return true;
    }
}
