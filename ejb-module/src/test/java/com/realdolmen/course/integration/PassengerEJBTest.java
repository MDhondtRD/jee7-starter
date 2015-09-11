package com.realdolmen.course.integration;

import com.realdolmen.course.Oefening.PassengerEJB;
import com.realdolmen.course.Oefening.PassengerEJBInterface;
import org.junit.Test;

import javax.naming.NamingException;

/**
 * Created by MDNAX30 on 11/09/2015.
 */
public class PassengerEJBTest extends RemoteIntegrationTest {

    @Test
    public void findAllPassengers() throws NamingException {
        PassengerEJBInterface ejb = lookup("ear-module-1.1/ejb-module-1.1/PassengerEJB!com.realdolmen.course.Oefening.PassengerEJBInterface");
        assertEquals(2, ejb.findPassengers().size());
    }

}
