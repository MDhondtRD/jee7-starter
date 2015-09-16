package com.realdolmen.exercise;

import com.realdolmen.course.persistence.DataSetPersistenceTest;
import org.junit.Test;

import java.util.Date;

public class TicketTest extends DataSetPersistenceTest {

    @Test
    public void ticketsCanBeCreatedWithAllPossibleConstructors(){
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket(49.95);
        assertNotNull(t1);
        assertNotNull(t2);
    }

    @Test
    public void ticketCanBePersisted(){
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket(49.95);
        entityManager().persist(t1);
        entityManager().persist(t2);
        entityManager().flush();
        assertNotNull(t1.getId());
        assertNotNull(t2.getId());
    }

    @Test
    public void ticketCanBeRetrievedById(){
        Ticket t = new Ticket(49.95);
        entityManager().persist(t);
        entityManager().flush();
        assertEquals((Double) 49.95, entityManager().find(Ticket.class, t.getId()).getPrice());
        assertEquals((Double) 19.99, entityManager().find(Ticket.class, new Long(1)).getPrice());
    }

    @Test
    public void flightsCanBeAddedToTicket(){
        Flight f1 = entityManager().find(Flight.class, new Long(1));
        Flight f2 = entityManager().find(Flight.class, new Long(3));
        Ticket ticket = new Ticket();
        ticket.setOutFlight(f1);
        ticket.setPrice(124.74);
        ticket.setReturnFlight(f2);
        ticket.setStatus(Status.PURCHASED);
        entityManager().persist(ticket);
        entityManager().flush();
        assertEquals(f1, entityManager().find(Ticket.class, ticket.getId()).getOutFlight());
        assertEquals(f2, entityManager().find(Ticket.class, ticket.getId()).getReturnFlight());
    }

    @Test
    public void newFlightsCanBeAddedToTicketWhilePersistingFlightsAsWell(){
        Flight f1 = new Flight("TST1");
        f1.setArrivalAirport(entityManager().find(Airport.class, 1));
        f1.setDepartureAirport(entityManager().find(Airport.class, 2));
        f1.setPlane(entityManager().find(Plane.class, 5));
        f1.setArrivalTime(new Date(1440108000000L));
        f1.setDepartureTime(new Date(1440104400000L));
        Flight f2 = new Flight("TST1");
        f2.setArrivalAirport(entityManager().find(Airport.class, 3));
        f2.setDepartureAirport(entityManager().find(Airport.class, 4));
        f2.setPlane(entityManager().find(Plane.class, 2));
        f2.setArrivalTime(new Date(1440108000000L));
        f2.setDepartureTime(new Date(1440104400000L));
        Ticket ticket = new Ticket();
        ticket.setOutFlight(f1);
        ticket.setPrice(124.74);
        ticket.setReturnFlight(f2);
        ticket.setStatus(Status.PURCHASED);
        entityManager().persist(f1);
        entityManager().persist(f2);
        entityManager().persist(ticket);
        entityManager().flush();
        assertNotNull(f1.getId());
        assertNotNull(f2.getId());
        assertEquals(f1, entityManager().find(Ticket.class, ticket.getId()).getOutFlight());
        assertEquals(f2, entityManager().find(Ticket.class, ticket.getId()).getReturnFlight());
    }

}
