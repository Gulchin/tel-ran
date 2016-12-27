package tel_ran.contacts.controller;

import java.io.*;

import tel_ran.contacts.dao.ContactsList;
import tel_ran.contacts.entities.*;
import tel_ran.contacts.repo.ContactsRepository;

public class ConttactsCreationAppl {

	public static void main(String[] args) throws  IOException {
		Address addr1=new Address("Israel", "Lod", "Sokolov", "10", 20);
		Address addr2=new Address("USA","New-York","Manhatan","unknown",0);
		CompanyInfo company=new CompanyInfo("Motorola",
			"Communication", 60000, addr2);
		Contact cont1=new FriendContact("5555555", "Vasya",
				"vasya@gmail.com", addr1, "sport") ;
		Contact cont2=new WorkContact("6666666", "Rivka", "rivka@gmail.com",
				addr1, company);
		ContactsRepository contacts=new ContactsList();
		contacts.addContact(cont1);
		contacts.addContact(cont2);
		saveContacts(contacts);

	}

	private static void saveContacts(ContactsRepository contacts)
			throws  IOException {
		ObjectOutputStream output=new ObjectOutputStream
				(new FileOutputStream("contacts.data"));
		output.writeObject(contacts);
		output.close();
		
	}

}
