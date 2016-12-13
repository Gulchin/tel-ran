package tel_ran.exceptionhandling;

public class Range {
	private int min,max;

	public Range(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}
	
	public boolean isMinimum(){
		return max-min<=1;
	}

	public int getMiddle(){
		return (int)Math.round(min/2.0d+max/2.0d);
	}
}
