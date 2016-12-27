package tel_ran.contacts.entities;

import java.io.Serializable;

public class Address implements Serializable{
String country;
String city;
String street;
String bld;
int aprt;
public Address(String country, String city, String street, String bld, int aprt) {
	super();
	this.country = country;
	this.city = city;
	this.street = street;
	this.bld = bld;
	this.aprt = aprt;
}
public String getCountry() {
	return country;
}
public String getCity() {
	return city;
}
public String getStreet() {
	return street;
}
public String getBld() {
	return bld;
}
public int getAprt() {
	return aprt;
}
@Override
public String toString() {
	return "Address [country=" + country + ", city=" + city + ", street=" + street + ", bld=" + bld + ", aprt=" + aprt
			+ "]";
}

}
