package com.realdolmen.exercise;

import com.realdolmen.course.persistence.DataSetPersistenceTest;
import com.realdolmen.exercise.domain.Passenger;
import org.junit.Test;

import javax.persistence.PersistenceException;

public class PassengerPersistenceTest extends DataSetPersistenceTest {

    @Test
    public void passengersCanBeCreatedWithAllPossibleConstructors(){
        Passenger p1 = new Passenger();
        Passenger p2 = new Passenger("93.04.22-099.69");
        Passenger p3 = new Passenger("94.11.05-099.69", "Pieter", "Dhondt");
        Passenger p4 = new Passenger("36.04.05-099.69", "Bob", "Dhondt", 4455);
    }

    @Test
    public void passengerCanBePersisted(){
        Passenger p = new Passenger("93.04.22-099.69");
        entityManager().persist(p);
        entityManager().flush();
        assertNotNull(entityManager().find(Passenger.class, p.getId()));
    }

    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersistedWithoutSsn(){
        Passenger p = new Passenger();
        entityManager().persist(p);
        entityManager().flush();
    }

    @Test
    public void passengerCanBeRetrievedById(){
        assertNotNull(entityManager().find(Passenger.class, 100L));
        assertNotNull(entityManager().find(Passenger.class, 101L));
        assertNotNull(entityManager().find(Passenger.class, 102L));
        assertNotNull(entityManager().find(Passenger.class, 103L));
    }

    @Test
    public void passengersCanBeRetrievedByNamedQuery(){
        assertEquals(4, entityManager().createNamedQuery(Passenger.FIND_ALL_PASSENGERS).getResultList().size());
        entityManager().clear();
        Passenger p = new Passenger("93.04.22-099.69");
        entityManager().persist(p);
        entityManager().flush();
        entityManager().clear();
        assertEquals(5, entityManager().createNamedQuery(Passenger.FIND_ALL_PASSENGERS).getResultList().size());
    }

}
