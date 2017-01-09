import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Cocroach extends Thread {
 private int number;
 public static int distance=10;
 public static int MIN_SLEEP=5;
 public static int MAX_SLEEP=500;
 public static int winner=-1;
 public static ConcurrentHashMap<Integer,Integer> progress= new ConcurrentHashMap<>();
 private static Thread observer;

public Cocroach(int number) {
	super();
	this.number = number;
}


public static void set(int nRunners,int dist,int min,int max){
	distance=dist;
	MIN_SLEEP=min;
	MAX_SLEEP=max;
	winner=-1;
	progress.clear();
	for (int i=0;i<nRunners;i++) progress.put(i, 0);
	observer=new Thread(new Runnable(){

		@Override
		public void run() {
			try {
			while(!interrupted()) {
			print();

				sleep(100);
			}
			} catch (InterruptedException e) {
			//	e.printStackTrace();
			}
		}});
	observer.start();
}

public static void finish(){
	observer.interrupt();
}

public static void print(){
	for(int i=0;i<5;i++)System.out.println();
	for(int i=0;i<distance;i++)System.out.print("_");
	System.out.println();
	for(Entry<Integer,Integer> entry:progress.entrySet()){
		for(int i=0;i<entry.getValue();i++) System.out.print("-");
		System.out.println(entry.getKey());
	}
	for(int i=0;i<distance;i++)System.out.print("_");
	System.out.println();
}

@Override
public void run() {
	for(int i=0;i<distance;i++){
		progress.put(number, i);
		try {
			sleep((int)(Math.random()*(MAX_SLEEP-MIN_SLEEP+1)+MIN_SLEEP));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	synchronized (Cocroach.class) {
		if (winner<0) {
			winner=number;
			finish();
		}
	}

}
 
}
