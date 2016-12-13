package tel_ran.sapes;

public class RectangleEmpty extends SquareEmty {
	private int height;

	public RectangleEmpty(char symbol, int width, int height) {
		super(symbol, width);
		this.height = height;
	}

	@Override
	public void draw() {
		drawEmpty(getWidth(), height);
	}	

}
