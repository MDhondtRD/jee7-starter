package com.realdolmen.exercise;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@NamedQuery(name = Passenger.FIND_ALL_PASSENGERS, query = "SELECT p FROM Passenger p")
@SecondaryTables({
        @SecondaryTable(name = "t_miles"),
        @SecondaryTable(name = "t_picture")
})
public class Passenger {

    // ATTRIBUTES

    public static final String FIND_ALL_PASSENGERS = "Passenger.findAllPassengers";

    @EmbeddedId
    private PassengerId id;

    @Column(length = 50)
    private String firstName;

    @Column(table = "t_miles")
    private Integer frequentFlyerMiles;

    @Basic(fetch = FetchType.LAZY)
    @Column(table = "t_picture")
    @Lob
    private byte[] picture;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, updatable = false)
    private Date dateOfBirth;

    @Transient
    private int age;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastFlight;

    @Enumerated(EnumType.STRING)
    private PassengerType type;




    // CONSTRUCTORS

    public Passenger(){
        // required no-argument constructor
    }

    public Passenger(String ssn, String lastName, Date dateOfBirth){
        PassengerId pI = new PassengerId(ssn, lastName);
        this.id = pI;
        setFirstName(null);
        setFrequentFlyerMiles(0);
        setPicture(null);
        this.dateOfBirth = dateOfBirth;
        this.age = calculateAge(dateOfBirth);
        setLastFlight(null);
        setType(PassengerType.REGULAR);
    }

    public Passenger(String ssn, String firstName, String lastName, Date dateOfBirth){
        PassengerId pI = new PassengerId(ssn, lastName);
        this.id = pI;
        setFirstName(firstName);
        setFrequentFlyerMiles(0);
        setPicture(null);
        this.dateOfBirth = dateOfBirth;
        this.age = calculateAge(dateOfBirth);
        setLastFlight(null);
        setType(PassengerType.REGULAR);
    }

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles, Date dateOfBirth){
        PassengerId pI = new PassengerId(ssn, lastName);
        this.id = pI;
        setFirstName(firstName);
        setFrequentFlyerMiles(frequentFlyerMiles);
        setPicture(null);
        this.dateOfBirth = dateOfBirth;
        this.age = calculateAge(dateOfBirth);
        setLastFlight(null);
        setType(PassengerType.REGULAR);
    }

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles, Date dateOfBirth, PassengerType type) {
        PassengerId pI = new PassengerId(ssn, lastName);
        this.id = pI;
        setFirstName(firstName);
        setFrequentFlyerMiles(frequentFlyerMiles);
        setPicture(null);
        this.dateOfBirth = dateOfBirth;
        this.age = calculateAge(dateOfBirth);
        setLastFlight(null);
        setType(type);
    }




    // GETTERS & SETTERS

    public PassengerId getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        if (isValidMiles(frequentFlyerMiles))
            this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        age = calculateAge(dateOfBirth);
        return age;
    }

    public Date getLastFlight() {
        return lastFlight;
    }

    public void setLastFlight(Date lastFlight) {
        this.lastFlight = lastFlight;
    }

    public PassengerType getType() {
        return type;
    }

    public void setType(PassengerType type) {
        this.type = type;
    }




    // METHODS

    public void addFrequentFlyerMiles(Integer miles){
        if (isValidMiles(miles))
            this.frequentFlyerMiles += miles;
    }

    private boolean isValidMiles(Integer miles){
        if (miles == null || miles < 0)
            throw new IllegalArgumentException("Illegal frequent flyer miles.");
        return true;
    }

    private int calculateAge(Date dateOfBirth){
        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();

        int age = 0;

        birthDate.setTime(dateOfBirth);
        if (birthDate.after(today)) {
            throw new IllegalArgumentException("Can't be born in the future");
        }

        age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

        // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year
        if ((birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3) || (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH ))){
            age--;
        // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
        } else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH )) && (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH ))){
            age--;
        }

        return age;
    }
}
