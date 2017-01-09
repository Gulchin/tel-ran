package tel_ran.sockets;

import java.net.*;
import java.io.*;

public class EchoClient {

	private static final int PORT_NUMBER = 10000;
	private static final String PROMPT="Send your input>";

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("localhost",PORT_NUMBER);
		System.out.println("Connected to the serwer");
		PrintStream serverStream=new PrintStream(socket.getOutputStream());
		BufferedReader serverReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		try(BufferedReader reader=new BufferedReader(new InputStreamReader(System.in))){
		while(true){

				System.out.println("enter line:");
				String input=reader.readLine();
				if("exit".equals(input)){
					socket.close();
					System.out.println("Connection with the server closed");
				}
				serverStream.println(input);
				String line=serverReader.readLine();
				System.out.println("server> "+line);

		}
		}catch(Exception e){
			
		}
	}

}
