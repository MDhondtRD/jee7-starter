package com.realdolmen.course.persistence;

import org.junit.Test;

import java.util.Date;
import com.realdolmen.course.Oefening.SavePassengers;

import javax.persistence.EntityManager;


public class SavePassengerTest extends DataSetPersistenceTest {


    @Test
    public void testOefening13(){
        SavePassengers sp = new SavePassengers();
        // Eigenlijk mag die "new" toestanden niet. Zou beter een JNDI lookup doen.
        // Maar dan moet uiteraard ook een remote interface nodig zijn voor SavePassengers()
        // Is wel beter omdat de persist() dan in SavePassengers kan gedaan worden ipv
        // hier in deze test.
        sp.createPassenger("17041991", "Maarten", "Dhondt", 1111, new Date());
        sp.addAddress();
        sp.addCreditCard();
        entityManager().persist(sp.addTicket());
        entityManager().persist(sp.checkOut());
        entityManager().flush();
    }

}
