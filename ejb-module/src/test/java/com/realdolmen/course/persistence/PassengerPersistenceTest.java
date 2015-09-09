package com.realdolmen.course.persistence;

import com.realdolmen.course.Passenger;
import com.realdolmen.course.domain.Book;
import org.junit.Test;

import javax.persistence.PersistenceException;

/**
 * Created by MDNAX30 on 9/09/2015.
 */
public class PassengerPersistenceTest extends DataSetPersistenceTest {

    @Test
    public void passengerCanBePersisted() throws Exception {
        Passenger p = new Passenger("17041991-099.96", "Maarten", "Dhondt", 5000);
        entityManager().persist(p);
        assertNotNull(p.getId());
    }

    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersistedWithoutSsn() throws Exception {
        Passenger p = new Passenger(null, "Maarten", "Dhondt", 5000);
        entityManager().persist(p);
    }

    @Test
    public void passengerCanBeRetrievedById() throws Exception {
        assertEquals("1234", entityManager().find(Passenger.class, new Long(4000)).getSsn());
    }
}
