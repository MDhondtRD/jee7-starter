package com.realdolmen.course.Oefening;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Stateful
public class SavePassengers {

    private Passenger p = null;

    public SavePassengers(){

    }

    public void createPassenger(String ssn, String fN, String lN, int fFM, Date dateOfBirth){
        p = new Passenger(ssn, fN, lN, fFM, dateOfBirth);
    }

    public void addAddress(){
        Address a = new Address("Straat", "Tweede straat", "Ronse", "9600", "Belgium");
        p.setAddress(a);
    }

    public void addCreditCard(){
        CreditCard cc = new CreditCard("12345", "nooit", 257, CreditCardType.VISA);
        p.addCreditCard(cc);
    }

    public Ticket addTicket(){
        Ticket t = new Ticket(499.95);
        p.addTicket(t);
        return t;
    }

    @Remove
    public Passenger checkOut(){
        return p;
    }

}
