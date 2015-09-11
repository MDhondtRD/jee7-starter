package com.realdolmen.course;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@EJB
public class PassengerEJB implements PassengerEJBInterface {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Passenger> findPassengers() {
        return em.createQuery("SELECT p FROM Passenger P", Passenger.class).getResultList();
    }

    @Override
    public Passenger findPassengerById(Long id) {
        return em.find(Passenger.class, id);
    }

    @Override
    public void createPassenger(Passenger passenger) {
        em.persist(passenger);
    }

    @Override
    public void deletePassenger(Passenger passenger) {
        em.remove(passenger);
    }

    @Override
    public void updatePassenger(Passenger passenger) {

    }
}
