package com.realdolmen.course;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MDNAX30 on 9/09/2015.
 */
@Entity
public class Passenger implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String ssn;
    private String firstName;
    private String lastName;
    private Integer frequentFlyerMiles;

    Passenger(){

    }

    public Passenger(String ssn, String fN, String lN, int fFM){
        this.ssn = ssn;
        this.firstName = fN;
        this.lastName = lN;
        this.frequentFlyerMiles = fFM;
    }

    public Long getId() {
        return id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
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
        this.frequentFlyerMiles = frequentFlyerMiles;
    }
}
