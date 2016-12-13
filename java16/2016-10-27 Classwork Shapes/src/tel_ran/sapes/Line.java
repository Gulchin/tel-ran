package tel_ran.sapes;

public abstract class Line extends Shape {
	private int length;

	public Line(char symbol, int length) {
		super(symbol);
		this.length = length;
	}

	public int getLength() {
		return length;
	}	


}
