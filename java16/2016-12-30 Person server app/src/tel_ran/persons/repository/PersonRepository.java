package tel_ran.persons.repository;

import java.io.Serializable;

import tel_ran.persons.entities.Person;

public interface PersonRepository extends Iterable<Person>,Serializable {
	boolean add(Person person);
	boolean remove(int id);
	Iterable<Person> getByName(String name);
	Iterable<Person> getByAge(int from, int to);
	Iterable<Person> getByCity(String city);
	Person get(int id);
}
