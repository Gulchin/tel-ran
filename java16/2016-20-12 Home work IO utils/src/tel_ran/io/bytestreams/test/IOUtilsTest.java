package tel_ran.io.bytestreams.test;

import static  tel_ran.io.bytestreams.FileUtils.*;

public class IOUtilsTest {

	public static void main(String[] args) {
		if (args.length<2) {
			System.out.println("Missing parametrs");
			return;
		}
		System.out.println("Contetnt of file "+args[0]+"->\n");
		printFile(args[0]);
		System.out.println("\nCopy file "+args[0]+" to file "+args[1]+"->\n");
		System.out.println(copyFile(args[0], args[1]));

	}

}
