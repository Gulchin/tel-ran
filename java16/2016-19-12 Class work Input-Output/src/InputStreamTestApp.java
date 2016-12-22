
import java.io.*;

// Дз написать две функции 1. распечатать в консоль файл
//2. Нвписать функцию которая копирует из одного файла в другой.
public class InputStreamTestApp {
 public static void main(String [] args) throws IOException{
	 FileInputStream stream = new FileInputStream("/Users/Ognerezov/Documents/Projects/Temp/1.txt");
	 int length=stream.available();
	 byte[] red= new byte[length];
	 stream.read(red);
	 System.out.println(new String(red));
	 stream.close();
	 for(String arg:args){
		 System.out.println(arg);
	 }
 }
}
