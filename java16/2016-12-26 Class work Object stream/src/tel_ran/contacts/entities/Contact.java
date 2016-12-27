package tel_ran.contacts.entities;

import java.io.Serializable;

public class Contact implements Serializable {
String phone;
String name;
String mail;
Address address;
public Contact(String phone, String name, String mail, Address address) {
	super();
	this.phone = phone;
	this.name = name;
	this.mail = mail;
	this.address = address;
}
public String getPhone() {
	return phone;
}
public String getName() {
	return name;
}
public String getMail() {
	return mail;
}
public Address getAddress() {
	return address;
}
@Override
public String toString() {
	return "Contact [phone=" + phone + ", name=" + name + ", mail=" + mail + ", address=" + address + "]";
}

}
