package ua.epam.rd.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
public class Address {
	
	private String city;
	private String street;
	private String house;
	
	public Address() {}
	
	public Address(String city, String street, String house) {
		this.city = city;
		this.street = street;
		this.house = house;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}


}
