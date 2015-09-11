package com.realdolmen.course.Oefening;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface PassengerEJBInterface {
    public List<Passenger> findPassengers();
    public Passenger findPassengerById(Long id);
    public void createPassenger(Passenger passenger);
    public void deletePassenger(Passenger passenger);
    public void updatePassenger(Passenger passenger);
}
