package com.realdolmen.exercise;

import com.realdolmen.course.persistence.DataSetPersistenceTest;
import org.junit.Test;

public class FlightTest extends DataSetPersistenceTest {

    @Test
    public void flightsCanBeCreatedWithAllPossibleConstructors(){
        Flight f1 = new DomesticFlight();
        Flight f2 = new InternationalFlight("XYZ314");
        assertNotNull(f1);
        assertNotNull(f2);
    }

    @Test
    public void flightCanBePersisted(){
        Flight f1 = new InternationalFlight();
        Flight f2 = new DomesticFlight("XYZ314");
        entityManager().persist(f1);
        entityManager().persist(f2);
        entityManager().flush();
        assertNotNull(f1.getId());
        assertNotNull(f2.getId());
    }

    @Test
    public void flightCanBeRetrievedById(){
        Flight f = new DomesticFlight("XYZ314");
        entityManager().persist(f);
        entityManager().flush();
        assertEquals("XYZ314", entityManager().find(Flight.class, f.getId()).getNumber());
        assertEquals("ABC11", entityManager().find(Flight.class, new Long(1)).getNumber());
    }
}
