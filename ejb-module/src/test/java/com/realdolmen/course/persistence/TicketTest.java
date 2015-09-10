package com.realdolmen.course.persistence;

import com.realdolmen.course.*;
import com.realdolmen.course.Ticket;
import org.junit.Test;

import java.util.Date;

/**
 * Created by MDNAX30 on 10/09/2015.
 */
public class TicketTest extends DataSetPersistenceTest{

    @Test
    public void testTicketCanBePersisted() {
        Ticket t = new Ticket(150.49);
        entityManager().persist(t);
        entityManager().flush();
        assertNotNull(t.getId());
    }

    @Test
    public void ticketCanBeRetrieved(){
        Ticket ticket = entityManager().find(Ticket.class, new Long(5000));
        assertEquals(199.99, ticket.getPrice(), 0.001);
    }

    @Test
    public void flightCanBeAssignedToATicket(){
        Ticket ticket = new Ticket(149.99);
        Flight f1 = new DomesticFlight("IBZ53", new Date(), new Date());
        Flight f2 = new DomesticFlight("GTW92", new Date(), new Date());
        ticket.setOut(f1);
        ticket.setReturnFlight(f2);
        entityManager().persist(f1);
        entityManager().persist(f2);
        entityManager().flush();
    }



}
