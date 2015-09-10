package com.realdolmen.course;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by MDNAX30 on 9/09/2015.
 */
@Entity
public class Passenger implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, updatable = false)
    private String ssn;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    private Integer frequentFlyerMiles;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false, updatable = false)
    private Date dateOfBirth;
    @Transient
    private byte age;
    @Enumerated(EnumType.STRING)
    private PassengerType pType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastFlight;
    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> preferences;
    @Embedded
    private Address address;
    @ElementCollection(fetch = FetchType.LAZY)
    private List<CreditCard> creditCards;

    public void addCreditCard(CreditCard cc){
        creditCards.add(cc);
    }

    public void addPreference(String p){
        preferences.add(p);
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getLastFlight() {
        return lastFlight;
    }

    public void setLastFlight(Date lastFlight) {
        this.lastFlight = lastFlight;
    }

    public PassengerType getpType() {
        return pType;
    }

    public void setpType(PassengerType pType) {
        this.pType = pType;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

    Passenger(){

    }

    public Passenger(String ssn, String fN, String lN, int fFM, Date dateOfBirth){
        this.ssn = ssn;
        this.firstName = fN;
        this.lastName = lN;
        this.frequentFlyerMiles = fFM;
        this.dateOfBirth = dateOfBirth;
        this.age = calculateAge();
        this.lastFlight = null;
        this.pType = PassengerType.REGULAR;
    }

    private byte calculateAge(){
        return 24;
    }

    public Passenger(String ssn, String fN, String lN, int fFM, Date dateOfBirth, PassengerType type){
        this.ssn = ssn;
        this.firstName = fN;
        this.lastName = lN;
        this.frequentFlyerMiles = fFM;
        this.dateOfBirth = dateOfBirth;
        this.age = calculateAge();
        this.lastFlight = null;
        this.pType = type;
    }

    public Long getId() {
        return id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte getAge(){
        return this.age;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }
}
