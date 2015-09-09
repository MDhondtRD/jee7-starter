package com.realdolmen.course.persistence;

import com.realdolmen.course.PassengerRepository;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by MDNAX30 on 9/09/2015.
 */
public class PassengerRepositoryTest extends DataSetPersistenceTest {

    private PassengerRepository repository;

    @Before
    public void initializeRepository() {
        repository = new PassengerRepository();
        repository.entityManager = entityManager();
    }

    @Test
    public void allPassengerCanBeRetrieved() throws Exception {
        assertEquals(1, repository.findAll().size());
    }

}
