package tel_ran.persons.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import tel_ran.persons.dao.PersonsMap;
import tel_ran.persons.entities.Person;

public class PersonMapTest {
	
	private static final int ID1 = 1;
	private static final String NAME1 = "Aaam";
	private static final String CITY1 = "EDEM";
	private static final int BIRTH_YEAR1 = 1900;
	private static final int ID2 = 2;
	private static final String NAME2 = "Kain";
	private static final int BIRTH_YEAR2 = 1990;
	private static final int ID3 = 3;
	private static final String NAME3 = "Avel";
	private static final int BIRTH_YEAR3 = 1991;
	private static final int ID4 = 112256;
	private static final int BIRTH_YEAR4 = 1999;
	private static final String CITY2 = "EARTH";
	private static final Person ADAM1=new Person(ID1, NAME1, BIRTH_YEAR1, CITY1);
	private static final Person ADAM2=new Person(ID4, NAME1, BIRTH_YEAR4, CITY2);
	private static final Person KAIN=new Person(ID2, NAME2, BIRTH_YEAR2, CITY1);
	private static final Person AVEL=new Person(ID3, NAME3, BIRTH_YEAR3, CITY1);
	
	PersonsMap map;
	private static final Person[] personArray={
			ADAM1,KAIN,AVEL,ADAM2};
	
	@Before
	public void init(){
		map=new PersonsMap();
		for(Person person: personArray){
			map.add(person);
		}
		
	}

	@Test
	public void testRemove() {
		for(Person person: personArray){
			assertTrue(map.remove(person.getId()));
		}
	}
	
	@Test
	public void testGetByName(){
		assertArrayEquals(new Person[]{ADAM1,ADAM2}, toArray(map.getByName(NAME1)));
	}
	
	@Test
	public void testGetByYear(){
		assertArrayEquals(new Person[]{KAIN,AVEL}, toArray(map.getByAge(1990, 1991)));
	}
	
	@Test
	public void testGetByCity(){
		assertArrayEquals(new Person[]{ADAM1,KAIN,AVEL}, toArray(map.getByCity(CITY1)));
	}
	
	private Person[] toArray(Iterable<Person> it){
		ArrayList<Person> list=new ArrayList<>();
		for(Person person: it){
			list.add(person);
		//	System.out.println(person.getId());
		}
		Person [] res=new Person[list.size()];
		return list.toArray(res);
	}

}
