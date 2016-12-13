package tel_ran.numbers;

import java.util.function.Consumer;

import tel_ran.numbers.interfaces.INumberBox;

public class NumberBoxPerformanceTest {
	INumberBox box;
	int nnumbers;
	int nrepeats;
	private int removeCount;
	public NumberBoxPerformanceTest(int nnumbers, int nrepeats) {
		super();
		this.nnumbers = nnumbers;
		this.nrepeats = nrepeats;
	}
	public INumberBox getBox() {
		return box;
	}
	public void setBox(INumberBox box) {
		this.box = box;
	}
	public int getNnumbers() {
		return nnumbers;
	}
	public int getNrepeats() {
		return nrepeats;
	}
	
	private void init(int nnum){
		box.clear();
		for (int i=0;i<nnum;i++){
			box.add(i);
		}
	}
	
	private long test(Consumer<Integer> consumer, int repeats,int nnum){
		init(nnum);
		long startTime=System.currentTimeMillis();
		for (int i=0;i<repeats;i++)
				consumer.accept(repeats+1);
		return System.currentTimeMillis()-startTime;
	}
	
	public long testContains(){
		return test(new Consumer<Integer>(){
			@Override
			public void accept(Integer t) {
				box.contains(t);
				
			}
			
		},nrepeats,nnumbers);
	}
	//Should return non existing element
	public long testRemove(){
		return test(new Consumer<Integer>(){
			@Override
			public void accept(Integer t) {
				box.removeNumber(t);				
			}			
		},nrepeats,nnumbers);
	}
	
	public long testRemoveOdd(){
		return test(new Consumer<Integer>(){
			@Override
			public void accept(Integer t) {
				box.removeOddNumbers();				
			}			
		},nrepeats,nnumbers);
	}
	
	public long testRemoveRange(){
		removeCount+=2;
		int count=removeCount;
		return test(new Consumer<Integer>(){
			@Override
			public void accept(Integer t) {
				box.removeNumbersInRange(t-count-2, t-count);
			}			
		},nrepeats,nnumbers);
	}
	
	public long testRemoveRepeated(){
		return test(new Consumer<Integer>(){
			@Override
			public void accept(Integer t) {
				box.removeRepeted();				
			}			
		},nrepeats,nnumbers);
	}
	
	

}
