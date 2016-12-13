package tel_ran.limitedqueue.controler;

import tel_ran.limitedqueue.LimitedQueue;
import tel_ran.limitedqueue.exceptions.IdleQueueException;
import tel_ran.limitedqueue.exceptions.RejectQueueException;

public class Player {
	

	private static final int QUEUE_SIZE = 10;
	private static final double PROBABILITY_ADD = 30;
	private static final int AMOUNT_TRIALS = 1000000;
	static LimitedQueue queue;

	public static void main(String[] args) {
		queue=new LimitedQueue(QUEUE_SIZE);
		int idleCount=0;
		int rejectCount=0;
		for(int i=0;i<AMOUNT_TRIALS;i++){
			try{
				playRandomAction();
			} catch(IdleQueueException e){
				idleCount++;
			} catch (RejectQueueException e){
				rejectCount++;
			}
		}
		System.out.printf("Total number of queue idle: %s, probability of idle: %s",idleCount,idleCount*100/AMOUNT_TRIALS);
		System.out.println();
		System.out.printf("Total number of queue reject: %s, probability of reject: %s%%",rejectCount,rejectCount*100.0/AMOUNT_TRIALS);
	}
	
	private static void playRandomAction() throws RejectQueueException{
		if(Math.random()*100<=PROBABILITY_ADD){
			queue.add((int)(Math.random()*Integer.MAX_VALUE));
		} else {
			queue.offer();
		}
	}

}
