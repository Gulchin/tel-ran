package tel_ran.persons.dao;

import tel_ran.persons.entities.Person;
import java.util.*;
import tel_ran.persons.repository.PersonRepository;

public class PersonsMap implements PersonRepository {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Map<Integer,Person> persons=new HashMap<>();
	Map<String,List<Person>> personsNames= new HashMap<>();
	TreeMap<Integer,List<Person>> personsYears=new TreeMap<>();
	
	@Override
	public boolean add(Person person) {
		int id=person.getId();
		if (persons.containsKey(id)) return false;
		persons.put(id, person);
		String name=person.getName();
		List<Person> thisNamePersons=personsNames.get(name);
		if(thisNamePersons==null){
			thisNamePersons =new ArrayList<>();
			personsNames.put(name, thisNamePersons);
		}
		thisNamePersons.add(person);
		int year=person.getBirthYear();
		List<Person> thisYearPersons = personsYears.get(year);
		if (thisYearPersons==null){
			thisYearPersons=new ArrayList<>();
			personsYears.put(year,thisYearPersons);
		}
		thisYearPersons.add(person);
		return true;
	}

	@Override
	public boolean remove(int id) {
		Person person=persons.remove(id);
		if (person==null) return false;
		String name=person.getName();
		List<Person> thisNamePersons=personsNames.get(name);
		thisNamePersons.remove(person);
		//we delete list only for personsNames because  probability to have person with equal names is low
		// but probability to have persons with equal age is high
		if(thisNamePersons.isEmpty()) personsNames.put(name, null);
		
		int year=person.getBirthYear();
		List<Person> thisYearPersons = personsYears.get(year);
		thisYearPersons.remove(person);
		
		return true;
	}

	@Override
	public Iterable<Person> getByName(String name) {
		return personsNames.get(name);
	}

	@Override
	public Iterable<Person> getByAge(int from, int to) {
		ArrayList<Person> res=new ArrayList<>();
		
		for(List<Person> personList: personsYears.subMap(from,true,to,true).values()){
			res.addAll(personList);
		}
		return res;
	}

	@Override
	public Iterable<Person> getByCity(String city) {
		ArrayList<Person> res=new ArrayList<>();
		for(Person person: persons.values()){
			if(person.getCity().equals(city)) res.add(person);
		}
		return res;
	}

	@Override
	public Person get(int id) {
		return persons.get(id);
	}

	@Override
	public Iterator<Person> iterator() {
		return persons.values().iterator();
	}

}
