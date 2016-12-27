package tel_ran.contacts.repo;

import java.io.Serializable;

import tel_ran.contacts.entities.Contact;

public interface ContactsRepository extends Iterable<Contact>,Serializable{
void addContact(Contact contact);
}
