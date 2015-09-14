package com.realdolmen.exercise;

import com.realdolmen.course.persistence.DataSetPersistenceTest;
import org.junit.Test;

import javax.persistence.PersistenceException;

public class PassengerTest extends DataSetPersistenceTest {

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

    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersistedWithNullSsn(){
        Passenger p = new Passenger(null);
        entityManager().persist(p);
        entityManager().flush();
    }

    @Test
    public void passengerCanBeRetrievedById(){
        PassengerId pI;
        pI = new PassengerId("91.04.17-099.69","Dhondt");
        assertNotNull(entityManager().find(Passenger.class, pI));
        assertEquals("Maarten", entityManager().find(Passenger.class, pI).getFirstName());
        pI = new PassengerId("95.07.14-099.69","Sysmans");
        assertNotNull(entityManager().find(Passenger.class, pI));
        assertEquals("Lien", entityManager().find(Passenger.class, pI).getFirstName());
        pI = new PassengerId("64.12.06-099.69","Dhondt");
        assertNotNull(entityManager().find(Passenger.class, pI));
        assertEquals("Hans", entityManager().find(Passenger.class, pI).getFirstName());
        pI = new PassengerId("68.02.24-099.69","Dewitte");
        assertNotNull(entityManager().find(Passenger.class, pI));
        assertEquals("Griet", entityManager().find(Passenger.class, pI).getFirstName());

        Passenger p = new Passenger("93.04.22-099.69");
        entityManager().persist(p);
        entityManager().flush();
        pI = new PassengerId("93.04.22-099.69","Doe");
        assertNotNull(entityManager().find(Passenger.class, pI));
        assertEquals("John", entityManager().find(Passenger.class, pI).getFirstName());
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
