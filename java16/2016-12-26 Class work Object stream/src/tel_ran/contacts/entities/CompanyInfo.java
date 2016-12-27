package tel_ran.contacts.entities;

import java.io.Serializable;

public class CompanyInfo implements Serializable{
String name;
String subject;
int numberEmployees;
Address address;
public CompanyInfo(String name, String subject, int numberEmployees, Address address) {
	super();
	this.name = name;
	this.subject = subject;
	this.numberEmployees = numberEmployees;
	this.address = address;
}
public String getName() {
	return name;
}
public String getSubject() {
	return subject;
}
public int getNumberEmployees() {
	return numberEmployees;
}
public Address getAddress() {
	return address;
}
@Override
public String toString() {
	return "CompanyInfo [name=" + name + ", subject=" + subject + ", numberEmployees=" + numberEmployees + ", address="
			+ address + "]";
}

}
