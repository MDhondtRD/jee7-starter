package com.realdolmen.course.Oefening;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by MDNAX30 on 9/09/2015.
 */
@Remote
public interface RemotePassengerRepository {
    List<Passenger> findAll();
}
