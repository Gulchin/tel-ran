package tel_ran.sockets;

import java.net.*;
import java.io.*;

public class EchoServer {
	

	private static final int PORT_NUMBER = 1000;

	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(PORT_NUMBER);
		System.out.println("server is running on port: " +PORT_NUMBER);
		while (true) {
			Socket socket = server.accept();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream printStream = new PrintStream(socket.getOutputStream());
			while (true) {
				String fromClient = reader.readLine();
				if (fromClient == null) {
					System.out.println("client close connection");
					break;
				}
				printStream.println("server hears yours: " + fromClient);
			} 
		}
	}

}
