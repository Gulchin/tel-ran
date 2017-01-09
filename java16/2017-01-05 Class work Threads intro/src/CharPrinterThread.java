
public class CharPrinterThread extends Thread {
 private char c;
 private int repeats;
public CharPrinterThread(char c, int repeats) {
	super();
	this.c = c;
	this.repeats = repeats;
}
@Override
public void run() {
 for (int i=0;i<repeats;i++) {
 System.out.print(c);
 try {
	sleep(4);
} catch (InterruptedException e) {
	e.printStackTrace();
}
 }
}
 
 
	
}
