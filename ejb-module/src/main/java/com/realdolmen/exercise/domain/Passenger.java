package com.realdolmen.exercise.domain;

import javax.persistence.*;

@Entity
public class Passenger {

    // ATTRIBUTES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ssn;

    private String firstName;

    private String lastName;

    private Integer frequentFlyerMiles;




    // CONSTRUCTORS

    public Passenger(){

    }

    public Passenger(String ssn){
        this.ssn = ssn;
        setFirstName("John");
        setLastName("Doe");
        setFrequentFlyerMiles(0);
    }

    public Passenger(String ssn, String firstName, String lastName){
        this.ssn = ssn;
        setFirstName(firstName);
        setLastName(lastName);
        setFrequentFlyerMiles(0);
    }

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles){
        this.ssn = ssn;
        setFirstName(firstName);
        setLastName(lastName);
        setFrequentFlyerMiles(frequentFlyerMiles);
    }



    // GETTERS && SETTERS

    public Long getId() {
        return id;
    }

    public String getSsn() {
        return ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        if (frequentFlyerMiles == null || frequentFlyerMiles < 0)
            throw new IllegalArgumentException("Illegal frequent flyer miles.");
        this.frequentFlyerMiles = frequentFlyerMiles;
    }




    // METHODS

    public void addFrequentFlyerMiles(Integer miles){
        if (frequentFlyerMiles == null || frequentFlyerMiles < 0)
            throw new IllegalArgumentException("Illegal frequent flyer miles.");
        this.frequentFlyerMiles += miles;
    }
}
