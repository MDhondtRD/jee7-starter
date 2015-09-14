package com.realdolmen.course.Oefening;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.concurrent.Future;

@Stateless
@Asynchronous
public class PaymentEJB implements PasymentEJBInterface{

    @PersistenceContext
    EntityManager em;

    @Override
    public Future<String> payByCreditCard() {
        return new AsyncResult<String>("Klaar!");
    }
}
