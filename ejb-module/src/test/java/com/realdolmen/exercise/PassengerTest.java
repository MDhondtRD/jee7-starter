package com.realdolmen.exercise;

import com.realdolmen.course.persistence.DataSetPersistenceTest;
import org.junit.Test;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.Date;

public class PassengerTest extends DataSetPersistenceTest {

    @Test
    public void passengersCanBeCreatedWithAllPossibleConstructors(){
        Passenger p1 = new Passenger();
        Passenger p2 = new Passenger("93.04.22-099.69", "Dhondt", new Date(735429600000L));
        Passenger p3 = new Passenger("94.11.05-099.69", "Pieter", "Dhondt", new Date(783990000000L));
        Passenger p4 = new Passenger("36.04.05-099.69", "Bob", "Dhondt", 4455, new Date(-1062295200000L));
        Passenger p5 = new Passenger("38.03.08-099.69", "Marie-Paule", "Oppalfens", 3333, new Date(-991360800000L), PassengerType.OCCASIONAL);
        Passenger p6 = new Passenger("38.03.08-099.69", "Marie-Paule", "Oppalfens", 3333, new Date(-991360800000L), PassengerType.OCCASIONAL, "Croix ou Pile 1", null, "Ronse", "9600", "Belgium");
    }

    @Test
    public void passengerCanBePersisted(){
        Passenger p = new Passenger("93.04.22-099.69", "Dhondt", new Date(735429600000L));
        entityManager().persist(p);
        entityManager().flush();
        assertNotNull(entityManager().find(Passenger.class, p.getId()));
    }

    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersistedWithoutSsnLastNameAndBirthdate(){
        Passenger p = new Passenger();
        entityManager().persist(p);
        entityManager().flush();
    }

    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersistedWithNullSsn(){
        Passenger p = new Passenger(null, "Dhondt", new Date(735429600000L));
        entityManager().persist(p);
        entityManager().flush();
    }

    @Test(expected = PersistenceException.class)
    public void passengerCanNotBePersistedWithNullLastName(){
        Passenger p = new Passenger("93.04.22-099.69", null, new Date(735429600000L));
        entityManager().persist(p);
        entityManager().flush();
    }

    @Test(expected = NullPointerException.class)
    public void passengerCanNotBePersistedWithNullBirthdate(){
        Passenger p = new Passenger("93.04.22-099.69", "Dhondt", null);
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

        Passenger p = new Passenger("93.04.22-099.69", "Dhondt", new Date(735429600000L));
        entityManager().persist(p);
        entityManager().flush();
        pI = new PassengerId("93.04.22-099.69","Dhondt");
        assertNotNull(entityManager().find(Passenger.class, pI));
        assertNull(entityManager().find(Passenger.class, pI).getFirstName());
    }

    @Test
    public void passengersCanBeRetrievedByNamedQuery(){
        assertEquals(4, entityManager().createNamedQuery(Passenger.FIND_ALL_PASSENGERS).getResultList().size());
        entityManager().clear();
        Passenger p = new Passenger("93.04.22-099.69", "Dhondt", new Date(735429600000L));
        entityManager().persist(p);
        entityManager().flush();
        entityManager().clear();
        assertEquals(5, entityManager().createNamedQuery(Passenger.FIND_ALL_PASSENGERS).getResultList().size());
    }

    @Test
    public void calculateAge(){
        // Tested on 15/09/2015
        assertEquals(24, entityManager().find(Passenger.class, new PassengerId("91.04.17-099.69", "Dhondt")).getAge());
        assertEquals(20, entityManager().find(Passenger.class, new PassengerId("95.07.14-099.69", "Sysmans")).getAge());
        assertEquals(50, entityManager().find(Passenger.class, new PassengerId("64.12.06-099.69", "Dhondt")).getAge());
        assertEquals(47, entityManager().find(Passenger.class, new PassengerId("68.02.24-099.69", "Dewitte")).getAge());
    }

    @Test
    public void addAndRetrievePreferences(){
        Passenger p = entityManager().find(Passenger.class, new PassengerId("91.04.17-099.69", "Dhondt"));
        p.addPreferences(new ArrayList<String>() {{add("A"); add("B"); add("C");}} );
        p.addPreference("D");
        entityManager().persist(p);
        entityManager().flush();
        entityManager().clear();
        assertEquals(6, entityManager().find(Passenger.class, new PassengerId("91.04.17-099.69", "Dhondt")).getPreferences().size());
    }

    @Test
    public void addAndRetrieveAddress(){
        Passenger p = entityManager().find(Passenger.class, new PassengerId("68.02.24-099.69", "Dewitte"));
        p.setCity("Sint-Kruis");
        p.setCountry("Belgium");
        p.setStreet1("Pijpeweg");
        entityManager().persist(p);
        entityManager().flush();
        entityManager().clear();
        assertEquals("Pijpeweg", entityManager().find(Passenger.class, new PassengerId("68.02.24-099.69", "Dewitte")).getStreet1());
    }

    @Test
    public void addAndRetrieveCreditCards(){
        Passenger p = entityManager().find(Passenger.class, new PassengerId("91.04.17-099.69", "Dhondt"));
        p.addCreditCard(new CreditCard("0000 0000 0000 0000", "nooit", 123, CreditCardType.AMEX));
        entityManager().persist(p);
        entityManager().flush();
        entityManager().clear();
        assertEquals(3, entityManager().find(Passenger.class, new PassengerId("91.04.17-099.69", "Dhondt")).getCreditCards().size());
    }

    @Test
    public void ticketsCanBeAdded(){
        Flight f1 = new DomesticFlight("TST1");
        f1.setArrivalAirport(entityManager().find(Airport.class, 1));
        f1.setDepartureAirport(entityManager().find(Airport.class, 2));
        f1.setPlane(entityManager().find(Plane.class, 5));
        f1.setArrivalTime(new Date(1440108000000L));
        f1.setDepartureTime(new Date(1440104400000L));
        Flight f2 = new DomesticFlight("TST1");
        f2.setArrivalAirport(entityManager().find(Airport.class, 3));
        f2.setDepartureAirport(entityManager().find(Airport.class, 4));
        f2.setPlane(entityManager().find(Plane.class, 2));
        f2.setArrivalTime(new Date(1440108000000L));
        f2.setDepartureTime(new Date(1440104400000L));
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        t1.setStatus(Status.PENDING);
        t2.setOutFlight(f1);
        t2.setPrice(124.74);
        t2.setReturnFlight(f2);
        t2.setStatus(Status.PURCHASED);
        Passenger p = new Passenger("38.03.08-099.69", "Marie-Paule", "Oppalfens", 3333, new Date(-991360800000L), PassengerType.OCCASIONAL, "Croix ou Pile 1", null, "Ronse", "9600", "Belgium");
        assertNotNull(t1);
        assertNotNull(p);
        p.addTicket(t1);
        p.addTicket(t2);
        entityManager().persist(f1);
        entityManager().persist(f2);
        entityManager().persist(t1);
        entityManager().persist(t2);
        entityManager().persist(p);
        entityManager().flush();
        assertNotNull(f1.getId());
        assertNotNull(f2.getId());
        assertNotNull(t1.getId());
        assertNotNull(t2.getId());
        assertNotNull(p.getId());
        assertTrue(entityManager().find(Passenger.class, p.getId()).getTickets().contains(t1));
        assertTrue(entityManager().find(Passenger.class, p.getId()).getTickets().contains(t2));
    }

}
