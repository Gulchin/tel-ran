package tel_ran.persons;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.*;

import tel_ran.persons.dao.PersonsMap;
import tel_ran.persons.entities.Person;
import tel_ran.persons.util.Procesasble;

public class PersonsApp {
	public static final String FILE_NAME="persons.data";
	public static final String PROMPT_ON_ERROR="Wrong input. Waiting for new input. Format: coomand#data";
	private static final String PERSON_ADDED = "Person has been aded";
	private static final String ALREADY_EXISTS = "Person with this id already exists";
	private static final String INVALID_PARAMETR = "Invalid parametr";
	private static final String REMOVED ="Person has been removed";
	private static final String DOESNT_HAVE = "Person id unknown";
	private static final int PORT = 10000;
	private static final String INVALID_OPERATION = "Invalid operation operation";
	static String PROMPT = 
			"type request in the format <request name >#<data relevant for request>\n"
			+ "add#<id> <name> <birth year> <city>\n"+
             "getPerson#<id>\n"+
             "getByName#<name>\n" +
             "getByAge#<year from> <year to>\n" +
             "getByCity#<city>\n"+
             "remove#<id>";
	private static PersonsMap map;
	private static Map<String,Procesasble> operations=new HashMap<>();
	private static HashSet<String> updateOps=new HashSet<>();
	static{
		operations.put("add", s->{ Person p=new Person();
				try {
					p.setData(s);
				} catch (Exception e) {
					return e.getMessage();
				}
				return map.add(p) ? PERSON_ADDED : ALREADY_EXISTS;}
		);
		operations.put("getperson",s->{
					try{
						int id=Integer.parseInt(s);
						return map.get(id).toString();
					} catch(Exception e){
						return INVALID_PARAMETR;
					}
		});
		
		operations.put("getbyname",s-> {return iterableToString(map.getByName(s));});
		operations.put("getbyage", s->{try{
						String []years=s.split(" ");
						return iterableToString(map.getByAge(Integer.parseInt(years[0]),Integer.parseInt(years[1])));
						}catch(Exception e){
							return INVALID_PARAMETR;
						}});
		operations.put("getbycity",s->{return iterableToString(map.getByCity(s));});
		operations.put("remove", s->{
					try{
						int id=Integer.parseInt(s);
						return map.remove(id) ? REMOVED : DOESNT_HAVE;
					} catch(Exception e){
						return INVALID_PARAMETR;
					}});
		operations.put("hello",s->{return PROMPT;});
		updateOps.add("add");
		updateOps.add("remove");
	}
	
	
	public static void main(String[] args) throws IOException {
		try(ObjectInputStream stream=new ObjectInputStream(new FileInputStream(FILE_NAME))){
			map=(PersonsMap)stream.readObject();		
		}catch(Exception e){
			map=new PersonsMap();
		}
		
		ExecutorService executor = Executors.newCachedThreadPool();
		ServerSocket server=new ServerSocket(PORT);
		System.out.println("Person service starts on port: "+PORT);
		while(true){
			Socket socket = server.accept();
			executor.submit(() ->{
				try{
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintStream printStream = new PrintStream(socket.getOutputStream());
				while (true) {
					
					String [] fromClient = reader.readLine().split("#");
					if (fromClient == null) {
						System.out.println("client close connection");

						break;
					}
					String op=fromClient[0].toLowerCase();
					Procesasble operation=operations.get(op);
					String responce=operation==null ? INVALID_OPERATION : operation.process(fromClient[1]);
					printStream.println(responce);
					System.out.println(responce);
					if (updateOps.contains(op)) save();
				} 
				}catch(IOException e){
					System.out.println(e.getMessage());
				} finally{
					try{
					socket.close();
					} catch(IOException e){
						e.printStackTrace();
					}
				}
			});
		}
	
	}

	private static void save(){
		try(ObjectOutputStream stream=new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
			stream.writeObject(map);
			stream.close();
			System.out.println("Data saved");
		}catch(Exception e){
			System.out.println("Error saving data");
		}
	}
	
	private static String iterableToString(Iterable<Person> it){
		StringBuilder res=new StringBuilder("");
		for(Person person:it){
			res.append(person.toString()+"\n");
		}
		return res.toString();
	}
	

}
