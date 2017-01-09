import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CocroachStadion {
	public static final int MAX_RUNNERS=100;
	public static final int DEFAULT_DISTANCE=10;
	public static final Cocroach[] runners=new Cocroach[MAX_RUNNERS];
	public static final String PROMPT="Input parametrs in format <n runners> <n steps> <sleep min> <sleepmax>"
			+ "or 'exit' for exit";

	static{
		for(int i=0;i<MAX_RUNNERS;i++){
			runners[i]=new Cocroach(i);
		}
	}
	
	public static void main(String [] args) throws InterruptedException{
		try(BufferedReader reader=new BufferedReader(new InputStreamReader(System.in))){
		while(true){
			System.out.println(PROMPT);
			try{
			String input =reader.readLine();
			if("exit".equals(input)){
				System.out.println("Come again!");
				break;
			}
			String[] params=input.split(" ");
			int nRunners=Integer.parseInt(params[0]);
			Cocroach.set(nRunners,Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]));

			nRunners=nRunners<=MAX_RUNNERS ?nRunners:MAX_RUNNERS;
			for (int i=0;i<nRunners;i++)runners[i]=new Cocroach(i);
			for (int i=0;i<nRunners;i++) runners[i].start();
			for (int i=0;i<nRunners;i++) runners[i].join();
			
			System.out.println("\nAnd the winner is: "+Cocroach.winner);
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	
	}catch(IOException e){
		e.printStackTrace();
	}
	}
}
