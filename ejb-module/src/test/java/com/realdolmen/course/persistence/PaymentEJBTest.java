package com.realdolmen.course.persistence;

import com.realdolmen.course.Oefening.PaymentEJB;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * Created by MDNAX30 on 14/09/2015.
 */
public class PaymentEJBTest extends DataSetPersistenceTest {

    private PaymentEJB payment = new PaymentEJB();

    @Test
    public void testPayment() throws ExecutionException, InterruptedException {
        assertEquals("Klaar!", payment.payByCreditCard().get());
    }

}
