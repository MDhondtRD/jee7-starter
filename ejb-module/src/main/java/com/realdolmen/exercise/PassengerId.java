package com.realdolmen.exercise;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PassengerId implements Serializable{

    // ATTRIBUTES

    private String ssn;

    private String lastName;




    // CONSTRUCTORS

    public PassengerId(){
        // required no-argument constructor
    }

    public PassengerId(String ssn, String lastName){
        setSsn(ssn);
        setLastName(lastName);
    }




    // GETTERS & SETTERS

    public String getSsn() {
        return ssn;
    }

    private void setSsn(String ssn){
        this.ssn = ssn;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }




    // METHODS


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassengerId that = (PassengerId) o;

        if (!getSsn().equals(that.getSsn())) return false;
        return !(getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null);

    }

    @Override
    public int hashCode() {
        int result = getSsn().hashCode();
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        return result;
    }
}
