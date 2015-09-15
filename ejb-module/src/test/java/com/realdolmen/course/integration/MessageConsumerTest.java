package com.realdolmen.course.integration;


import org.junit.Test;

public class MessageConsumerTest extends RemoteJmsTest {

    @Test
    public void produceTextMessage1() throws Exception {
        producer.send(session.createTextMessage("5000,149.95,xxx,xxx"));
    }

    @Test
    public void produceTextMessage2() throws Exception {
        producer.send(session.createTextMessage("null,49.95,50,4000"));
    }
}
