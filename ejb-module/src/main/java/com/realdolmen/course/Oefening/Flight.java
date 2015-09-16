package com.realdolmen.course.Oefening;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by MDNAX30 on 10/09/2015.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Flight implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String number;
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalTime;
    @OneToMany
    private List<Ticket> tickets;

    public Flight(String number, Date departureTime, Date arrivalTime) {
        this.number = number;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        tickets = new ArrayList<Ticket>();
    }

    public Flight() {

    }

    public long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
