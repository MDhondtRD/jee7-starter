package com.realdolmen.course.Oefening;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/MyQueue"),
})
public class MessageConsumer implements MessageListener {

    @PersistenceContext
    public EntityManager em;

    @Override
    public void onMessage(Message message){
        System.out.println("***************************************************");
        try {
            TextMessage textMessage = (TextMessage) message;
            String[] words = textMessage.getText().split(",");
            Long ticketId = null;
            if (!words[0].equals("null"))
                ticketId = new Long(words[0]);
            Double price =  Double.parseDouble(words[1]);
            long flightId;
            long passengerId;
            if (ticketId != null) {
                Ticket ticket = em.find(Ticket.class, ticketId);
                ticket.setPrice(price);
            } else {
                flightId = new Long(words[2]);
                Flight flight = em.find(Flight.class, flightId);
                passengerId = new Long(words[3]);
                Passenger passenger = em.find(Passenger.class, passengerId);
                Ticket ticket = new Ticket(price);
                ticket.setOut(flight);
                ticket.setPassenger(passenger);
                em.persist(ticket);
                em.persist(flight);
                em.persist(passenger);
                em.flush();
            }
        } catch (JMSException e) {
            throw new RuntimeException("Deal with this", e);
        }
    }

}
