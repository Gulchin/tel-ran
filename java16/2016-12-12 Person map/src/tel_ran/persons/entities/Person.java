package tel_ran.persons.entities;

public class Person {
	private int id;
	private String name;
	private int birthYear;
	private String city;	

	

	public Person() {
		super();
	}
	public Person(int id, String name, int birthYear, String city) {
		super();
		this.id = id;
		this.name = name;
		this.birthYear = birthYear;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public String getCity() {
		return city;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	

}
