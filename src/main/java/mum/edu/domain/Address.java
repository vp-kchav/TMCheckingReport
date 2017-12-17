/*
 * Created on Dec 2, 2017
 */
package mum.edu.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Embeddable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address {

    @NotEmpty
    @NotNull
    private String street;
    @NotEmpty
    @NotNull
    private String city;
    @NotEmpty
    @NotNull
    private String state;
    @NotEmpty
    @NotNull
    private String zipCode;

    public Address() {
        
    }
    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getZipCode() {
        return zipCode;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getStreet()).append(" ");
        builder.append(this.getCity()).append(" ");
        builder.append(this.getState()).append(" ");
        builder.append(this.getZipCode());
        return builder.toString();
    }
   
}
