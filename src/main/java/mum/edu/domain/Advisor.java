package mum.edu.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Advisor {
	@Id
	@GeneratedValue
	private int id;
	private String firstname;
	private String lastname;
	private int advisorID;
    @Embedded
    private Address address;
    
    public Advisor() {
    	
    }
    
    public Advisor(String firstname,String lastname,int advisorID, Address address) {
    	this.firstname=firstname;
    	this.lastname=lastname;
    	this.advisorID=advisorID;
    	this.address=address;
    }
    
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAdvisorID() {
		return advisorID;
	}
	public void setAdvisorID(int advisorID) {
		this.advisorID = advisorID;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Advisor [firstname=" + firstname + ", lastname=" + lastname + ", advisorID=" + advisorID + ", address="
				+ address + "]";
	}

	public int getId() {
		return id;
	}

}
