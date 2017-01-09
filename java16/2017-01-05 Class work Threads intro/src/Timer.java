import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.text.*;

public class Timer extends Thread {
	

	public Timer() {
		super();
		setDaemon(true);
	}

	@Override
	public void run() {
		DateFormat df=new SimpleDateFormat("hh:mm:ss");
		while(true){
			System.out.println("\n"+df.format(new Date()));
		//System.out.println(LocalTime.now());
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("\ninterrapted at:"+df.format(new Date()));
		}
		}
	}

}
