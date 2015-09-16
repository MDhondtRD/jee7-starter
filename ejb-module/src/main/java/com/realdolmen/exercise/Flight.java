package com.realdolmen.exercise;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance
public abstract class Flight {

    // ATTRIBUTES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @Temporal(TemporalType.TIMESTAMP)
    private Date departureTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalTime;

    @ManyToOne
    private Plane plane;

    @ManyToOne
    private Airport departureAirport;

    @ManyToOne
    private Airport arrivalAirport;




    // CONSTRUCTORS

    public Flight() {
        // required no-argument constructor
    }

    public Flight(String number) {
        this.number = number;
    }




    // GETTERS & SETTERS

    public Long getId() {
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

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
}
