package com.realdolmen.course.Oefening;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.Date;
import java.util.List;

/**
 * Created by MDNAX30 on 10/09/2015.
 */
@Entity
public class DomesticFlight extends Flight {

    private String airlineCompany;
    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> preferences;

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

    public DomesticFlight() {
    }

    public DomesticFlight(String number, Date departureTime, Date arrivalTime) {
        super(number, departureTime, arrivalTime);
    }

    public DomesticFlight(String airlineCompany, List<String> preferences) {
        this.airlineCompany = airlineCompany;
        this.preferences = preferences;
    }

    public DomesticFlight(String number, Date departureTime, Date arrivalTime, String airlineCompany, List<String> preferences) {
        super(number, departureTime, arrivalTime);
        this.airlineCompany = airlineCompany;
        this.preferences = preferences;
    }

    public void addPreference(String p){
        this.preferences.add(p);
    }

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }
}
