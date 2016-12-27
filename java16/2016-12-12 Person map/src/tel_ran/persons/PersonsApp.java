package tel_ran.persons;

import java.io.*;

import tel_ran.persons.dao.PersonsMap;
import tel_ran.persons.entities.Person;

public class PersonsApp {
	public static final String FILE_NAME="persons.data";
	public static final String PROMPT="Waiting for input. Format: coomand#data";
	public static final String PROMPT_ON_ERROR="Wrong input. Waiting for new input. Format: coomand#data";
	private static PersonsMap map;
	
	public static void main(String[] args) {
	try(ObjectInputStream stream=new ObjectInputStream(new FileInputStream(FILE_NAME))){
		map=(PersonsMap)stream.readObject();		
	}catch(Exception e){
		map=new PersonsMap();
	}
	String prompt=PROMPT;
	try (BufferedReader reader=new BufferedReader(new InputStreamReader(System.in))){
		while(true){
			System.out.println(prompt);
			String input=reader.readLine();
			if("exit".equals(input)) break;
			try{
				processLine(input);
				prompt=PROMPT;
			} catch (Exception e){
				System.out.println(e.getMessage());
				prompt=PROMPT_ON_ERROR;
			}
		}
	} catch(Exception e){
		
	}
	try(ObjectOutputStream stream=new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
		stream.writeObject(map);
		stream.close();
		System.out.println("Data saved");
	}catch(Exception e){
		System.out.println("Error saving data");
	}
	
	}


	private static void processLine(String input) throws Exception{
		String []data=input.split("#");
		if (data.length<2) throw new IllegalArgumentException("Not enough data");
		switch(data[0].toLowerCase()){
		case "add": 
			Person person=new Person();
			person.setData(data[1]);		
			if(map.add(person)) System.out.println("The person have been added");
			else System.out.println("Error adding person - id duplication");
			break;
		case "getperson":
			System.out.println(map.get(Integer.parseInt(data[1])));
			break;
		case "getbyname":
			printIterable(map.getByName(data[1]));
			break;
		case "getbyage":
			String [] years=data[1].split(" ");
			printIterable(map.getByAge(Integer.parseInt(years[0]),Integer.parseInt(years[1])));
			break;
		case "getbycity":
			printIterable(map.getByCity(data[1]));
			break;
		case "remove":
			if (map.remove(Integer.parseInt(data[1]))) System.out.println("removed");
			else System.out.println("Invalid id");
			break;
		default: throw new IllegalArgumentException("Invalid operation");
		}

	}
	
	private static void printIterable(Iterable<Person> it){
		for(Person person:it){
			System.out.println(person);
		}
	}

}
