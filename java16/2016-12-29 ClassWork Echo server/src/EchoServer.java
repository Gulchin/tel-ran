import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
//Дз сделать приложение - сделать Персон Апликейшен в виде серверного приложения 
// Консольное приложение отправляет команды, а север работает с базой.
public class EchoServer {

	private static final int PORT_NUMBER = 10000;

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
