package tel_ran.sockets;

import java.net.*;
import java.io.*;

public class PersonClient {

	private static final int PORT_NUMBER = 10000;
	private static final String HELLO = "hello# ";

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("localhost",PORT_NUMBER);
		System.out.println("Connected to the server");
		PrintStream serverStream=new PrintStream(socket.getOutputStream());
		BufferedReader serverReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		try(BufferedReader reader=new BufferedReader(new InputStreamReader(System.in))){		
					serverStream.println(HELLO);
					String prompt=serverReader.readLine();
					while(serverReader.ready()){
					prompt+=serverReader.readLine()+"\n";
					}
		while(true){
				System.out.println(prompt);
				String input=reader.readLine();
				if("exit".equals(input)){
					socket.close();
					System.out.println("Connection with the server closed");
					break;
				}
				serverStream.println(input);
				String line=serverReader.readLine();
				System.out.println("server> "+line);
				//Нужно нормально отрабатывать конец сообщения
				while(serverReader.ready()){
				line=serverReader.readLine();
				System.out.println("server> "+line);
				}
		}
		}catch(Exception e){
			
		}
	}

}
