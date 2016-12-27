import java.io.*;

public class PrintStremWriterApp {
	static PrintWriter writer;
	static PrintStream stream;
	static int Nrec=1000000;
	
	public static void main(String[] args) throws IOException {
		writer=new PrintWriter("writer-file");
		stream=new PrintStream("stream-file");
		Long time=System.currentTimeMillis();
		testPrintWriter();
		System.out.println("writer results: "+(System.currentTimeMillis()-time));
		time=System.currentTimeMillis();
		testPrintStream();
		System.out.println("stream results: "+(System.currentTimeMillis()-time));
		
	}

	private static void testPrintStream() {
		for(int i=0;i<Nrec;i++){
			stream.println("hello!");
		}
		stream.close();
	}

	private static void testPrintWriter() {
		for(int i=0;i<Nrec;i++){
			writer.println("hello!");
		}
		writer.close();
	}
	


}
