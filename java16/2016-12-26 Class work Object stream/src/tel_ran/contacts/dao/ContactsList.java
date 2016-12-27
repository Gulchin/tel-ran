package tel_ran.contacts.dao;

import java.util.*;

import tel_ran.contacts.entities.Contact;
import tel_ran.contacts.repo.ContactsRepository;

public class ContactsList implements ContactsRepository{
List<Contact> contacts;
public ContactsList() {
	contacts=new ArrayList<>();
}
	@Override
	public Iterator<Contact> iterator() {
		return contacts.iterator();
	}

	@Override
	public void addContact(Contact contact) {
		contacts.add(contact);
		
	}

}
