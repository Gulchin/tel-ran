package tel_ran.persons.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3772353478429566233L;
	private int id;
	private String name;
	private int birthYear;
	private String city;	
	public static final int MAXIMUM_AGE=200;
	public static final int MINIMUM_AGE=0;
	
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
	
	public void setData(String prsData) throws Exception {
		String [] data=prsData.split(" ");
		if (data.length<4) throw new IllegalArgumentException("Not enough data");
		this.id=Integer.parseInt(data[0]);
		this.name=data[1];
		this.birthYear=Integer.parseInt(data[2]);
		int currnetYear=LocalDate.now().getYear();
		if(this.birthYear>currnetYear-MINIMUM_AGE ||this.birthYear<currnetYear-MAXIMUM_AGE)
			throw new IllegalArgumentException("Birth year beyond the limits");
		this.city=data[3];
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
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", birthYear=" + birthYear + ", city=" + city + "]";
	}
	
	
	
	

}
