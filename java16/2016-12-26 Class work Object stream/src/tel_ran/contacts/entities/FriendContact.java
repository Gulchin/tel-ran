package tel_ran.contacts.entities;

public class FriendContact extends Contact {
String commonInterest;

public FriendContact(String phone, String name, String mail, Address address, String commonInterest) {
	super(phone, name, mail, address);
	this.commonInterest = commonInterest;
}

public String getCommonInterest() {
	return commonInterest;
}

@Override
public String toString() {
	return "FriendContact [commonInterest=" + commonInterest + ", phone=" + phone + ", name=" + name + ", mail=" + mail
			+ ", address=" + address + "]";
}

}
