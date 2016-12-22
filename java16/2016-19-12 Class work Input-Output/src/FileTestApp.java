import java.io.*;
import java.util.Arrays;

public class FileTestApp {

	public static void main(String[] args) throws IOException {
		File file = new File("/Users/Ognerezov/Documents/Projects/Temp/1.txt");
		System.out.println(file.exists());
		FileOutputStream stream=new FileOutputStream(file);
		stream.write("Hello 1234".getBytes());
		stream.close();
		stream=new FileOutputStream(file,true);
		stream.write(" Written after".getBytes());
		stream.close();
		//System.out.println(Arrays.deepToString(file.listFiles()));
//		file.createNewFile();
//		System.out.println(file.exists());
	}

}
