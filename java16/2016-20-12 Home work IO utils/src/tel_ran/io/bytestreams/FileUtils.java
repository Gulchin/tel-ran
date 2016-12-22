package tel_ran.io.bytestreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileUtils {

public static void printFile(String fileName){
	
	try(FileInputStream stream = new FileInputStream(fileName)) 
	{		
		 byte[] red= new byte[1024];
		 while(stream.available()>0){
		 stream.read(red);
		 System.out.write(red);
		 }

	} catch (FileNotFoundException e) {
		System.out.println("File "+fileName+" not found");
	} catch (IOException e) {
		System.out.println("Error reading file "+fileName);
	}
}

public static String copyFile(String inputFileName, String outputFileName){

	byte[] red=new byte[1024];
	try(FileInputStream stream = new FileInputStream(inputFileName);
			FileOutputStream outStream = new FileOutputStream(outputFileName)) 
	{		
		 while(stream.available()>0){
		 stream.read(red);
		 outStream.write(red);
		 }

	} catch (FileNotFoundException e) {
		return "File not found";
	} catch (IOException e) {
		return "Error reading file ";
	}
		
	return 	"File copied";
}

}
