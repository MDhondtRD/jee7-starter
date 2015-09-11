package com.realdolmen.course.Oefening;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by MDNAX30 on 10/09/2015.
 */
@Entity
public class InternationalFlight extends Flight {

    private boolean blacklisted;
    private String regulations;

    public InternationalFlight(String number, Date departureTime, Date arrivalTime, boolean blacklisted, String regulations) {
        super(number, departureTime, arrivalTime);
        this.blacklisted = blacklisted;
        this.regulations = regulations;
    }

    public InternationalFlight(boolean blacklisted, String regulations) {
        this.blacklisted = blacklisted;
        this.regulations = regulations;
    }

    public InternationalFlight() {
    }

    public InternationalFlight(String number, Date departureTime, Date arrivalTime) {
        super(number, departureTime, arrivalTime);
    }

    public boolean isBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(boolean blacklisted) {
        this.blacklisted = blacklisted;
    }

    public String getRegulations() {
        return regulations;
    }

    public void setRegulations(String regulations) {
        this.regulations = regulations;
    }
}
