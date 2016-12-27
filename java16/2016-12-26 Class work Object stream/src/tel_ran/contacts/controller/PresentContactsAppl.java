package tel_ran.contacts.controller;
import java.io.*;

import tel_ran.contacts.entities.Contact;
import tel_ran.contacts.repo.ContactsRepository;
public class PresentContactsAppl {

	public static void main(String[] args) throws  Exception {
		ObjectInputStream input=
				new ObjectInputStream(new FileInputStream("contacts.data"));
		ContactsRepository contacts=(ContactsRepository) input.readObject();
		for (Contact contact:contacts)
			System.out.println(contact);
		input.close();

	}

}
