package com.realdolmen.exercise.persistence;


import com.realdolmen.exercise.domain.Passenger;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface RemotePassengerRepository {

    List<Passenger> findAll();

}
