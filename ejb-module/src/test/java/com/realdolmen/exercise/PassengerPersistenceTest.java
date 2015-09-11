package com.realdolmen.exercise;

import com.realdolmen.course.persistence.DataSetPersistenceTest;
import com.realdolmen.exercise.domain.Passenger;
import org.junit.Test;

public class PassengerPersistenceTest extends DataSetPersistenceTest {

    @Test
    public void passengerCanBePersisted(){
        Passenger p = new Passenger("258");
        entityManager().persist(p);
        entityManager().flush();
        assertNotNull(entityManager().find(Passenger.class, p.getId()));
    }

}
