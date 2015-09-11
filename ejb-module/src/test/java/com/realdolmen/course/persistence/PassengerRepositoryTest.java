package com.realdolmen.course.persistence;

import com.realdolmen.course.Oefening.PassengerRepository;
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
        assertEquals(2, repository.findAll().size());
    }

    @Test
    public void allLastNamesCanBeRetrieved() {
        assertTrue(repository.findAllLastNames().contains("Dhondt"));
        assertTrue(repository.findAllLastNames().contains("Sysmans"));
    }

    @Test
    public void totalFrequentFlyerMiles() {
        assertEquals(new Long(3000), repository.totalFrequentFlyerMiles());
    }

//    @Test
//    public void deleteAll(){
//        assertEquals(2, repository.findAll().size());
//        repository.deleteAll();
//        assertEquals(0, repository.findAll().size());
//    }

}
