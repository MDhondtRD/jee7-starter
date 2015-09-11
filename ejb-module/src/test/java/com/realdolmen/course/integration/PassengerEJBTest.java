package com.realdolmen.course.integration;

import com.realdolmen.course.PassengerEJB;
import com.realdolmen.course.persistence.DataSetPersistenceTest;
import org.junit.Test;

/**
 * Created by MDNAX30 on 11/09/2015.
 */
public class PassengerEJBTest extends RemoteIntegrationTest {

    @Test
    public void findAllPassengers(){
        PassengerEJB ejb = new PassengerEJB();
        assertEquals(2, ejb.findPassengers().size());
    }

}
