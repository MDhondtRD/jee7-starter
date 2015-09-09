package com.realdolmen.course;

import com.realdolmen.course.Passenger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by MDNAX30 on 9/09/2015.
 */
@Stateless
@LocalBean
public class PassengerRepository implements RemotePassengerRepository {

    @PersistenceContext
    public EntityManager entityManager;

    public List<Passenger> findAll() {
        return entityManager.createQuery("select p from Passenger p", Passenger.class).getResultList();
    }

}
