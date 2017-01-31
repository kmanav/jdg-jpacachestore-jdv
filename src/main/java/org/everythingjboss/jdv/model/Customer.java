package org.everythingjboss.jdv.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import com.google.gson.Gson;

@Entity
@Table(name="all_customers")
public class Customer implements Serializable {

    @Id
    @Column(unique = true, nullable = false, length = 12)
    private String CustomerID;
    @Column
    private String FirstName;
    @Column
    private String LastName;
    @Column
    private String State;
    @Column
    private String Country;
    private static final long serialVersionUID = 1L;

    public Customer() {
        super();
    }   
    
    public String getCustomerID() {
        return this.CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }   
    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }   
    public String getLastName() {
        return this.LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }   
    public String getState() {
        return this.State;
    }

    public void setState(String State) {
        this.State = State;
    }   
    public String getCountry() {
        return this.Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
