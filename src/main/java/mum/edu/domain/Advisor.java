package mum.edu.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Advisor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	@Column(name="advisorid")
	private String advisorid;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    public Advisor() {
    	
    }
    
    public Advisor(String firstname,String lastname,String advisorid, Address address) {
    	this.firstname=firstname;
    	this.lastname=lastname;
    	this.advisorid=advisorid;
    	this.address=address;
    }
    
    
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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
	public String getAdvisorid() {
		return advisorid;
	}
	public void setAdvisorid(String advisorid) {
		this.advisorid = advisorid;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Advisor [firstname=" + firstname + ", lastname=" + lastname + ", advisorid=" + advisorid + ", address="
				+ address + "]";
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
	    this.id = id;
	}

}
