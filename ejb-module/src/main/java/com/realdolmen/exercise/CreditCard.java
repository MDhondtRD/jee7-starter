package com.realdolmen.exercise;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class CreditCard {

    // ATTRIBUTES

    private String number;

    private String expiryDate;

    private Integer controlNumber;

    @Enumerated(EnumType.STRING)
    private CreditCardType type;




    // CONSTRUCTORS

    public CreditCard(){
        // required no-argument constructor
    }

    public CreditCard(String number, String expiryDate, Integer controlNumber, CreditCardType type) {
        this.number = number;
        this.expiryDate = expiryDate;
        this.controlNumber = controlNumber;
        this.type = type;
    }




    // GETTERS & SETTERS

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(Integer controlNumber) {
        this.controlNumber = controlNumber;
    }

    public CreditCardType getType() {
        return type;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }
}
