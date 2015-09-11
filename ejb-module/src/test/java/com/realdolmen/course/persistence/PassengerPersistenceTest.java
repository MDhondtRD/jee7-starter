package com.realdolmen.course.persistence;

import com.realdolmen.course.Oefening.Passenger;
import com.realdolmen.course.Oefening.PassengerType;
import org.junit.Test;

import javax.persistence.PersistenceException;
import java.util.Date;

/**
 * Created by MDNAX30 on 9/09/2015.
 */
public class PassengerPersistenceTest extends DataSetPersistenceTest {

    @Test
    public void passengerCanBePersisted() throws Exception {
        Passenger p = new Passenger("17041991-099.96", "Maarten", "Dhondt", 5000, new Date(), PassengerType.REGULAR);
        entityManager().persist(p);
        entityManager().flush();
        assertNotNull(p.getId());
    }

    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersistedWithoutSsn() throws Exception {
        Passenger p = new Passenger(null, "Maarten", "Dhondt", 5000, new Date());
        entityManager().persist(p);
    }

    @Test
    public void passengerCanBeRetrievedById() throws Exception {
        assertEquals("1234", entityManager().find(Passenger.class, new Long(4000)).getSsn());
    }

    @Test
    public void passengerHasCorrectAge(){
        Passenger p = new Passenger("17041991-099.96", "Maarten", "Dhondt", 5000, new Date(671846400));
        entityManager().persist(p);
        entityManager().flush();
        assertEquals(24, p.getAge());
    }

    @Test
    public void passengerHasPreferences(){
        Passenger p = new Passenger("17041991-099.96", "Maarten", "Dhondt", 5000, new Date(), PassengerType.REGULAR);
        p.addPreference("test1");
        p.addPreference("test2");
        p.addPreference("test3");
        entityManager().persist(p);
        entityManager().flush();
        assertEquals(3, entityManager().find(Passenger.class, p.getId()).getPreferences().size());
    }
}
