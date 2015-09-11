package com.realdolmen.course.persistence;

import com.realdolmen.course.Oefening.DomesticFlight;
import com.realdolmen.course.Oefening.Flight;
import com.realdolmen.course.Oefening.InternationalFlight;
import com.realdolmen.course.Oefening.Ticket;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by MDNAX30 on 10/09/2015.
 */
public class FlightPersistenceTest extends DataSetPersistenceTest {

    @Test
    public void testPolymorphism(){
        Ticket ticket = new Ticket(149.99);
        DomesticFlight f1 = new DomesticFlight("IBZ53", new Date(), new Date(), "Company", new ArrayList<String>());
        InternationalFlight f2 = new InternationalFlight("GTW92", new Date(), new Date(), false, "none");
        ticket.setOut(f1);
        ticket.setReturnFlight(f2);
        entityManager().persist(f1);
        entityManager().persist(f2);
        entityManager().flush();
        assertEquals(entityManager().find(Flight.class, f1.getId()).getNumber(), "IBZ53");
        assertEquals(((InternationalFlight)entityManager().find(Flight.class, f2.getId())).getRegulations(), "none");
    }
}
