package tel_ran.sapes;

public class LineHorizontally extends Line {

	
	public LineHorizontally(char symbol, int length) {
		super(symbol, length);

	}

	@Override
	public void draw() {
		drawLine(getLength());
		nextLine();
	}

}
