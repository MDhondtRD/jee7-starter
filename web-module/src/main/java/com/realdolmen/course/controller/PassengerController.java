package com.realdolmen.course.controller;

import com.realdolmen.course.Oefening.*;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class PassengerController implements Serializable{

    @Inject
    PassengerEJB repository;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private Double price;

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    private Passenger passenger;

    public List<Passenger> getAllPassengers() {
        return repository.findPassengers();
    }

    public InternationalFlight getFlight() {
        return flight;
    }

    public void setFlight(InternationalFlight flight) {
        this.flight = flight;
    }

    private InternationalFlight flight;

    public List<InternationalFlight> getAllFlights(){
        return repository.findFlights();
    }

    public void findFlight(Long id){
        flight = (InternationalFlight) repository.findFlight(id);
    }

    public String persistPrice(){
        System.out.println(price);
        return "bookitem";
    }



}
