package tel_ran.sapes;

public class Square extends LineHorizontally {

	public Square(char symbol, int length) {
		super(symbol, length);
	}

	protected void drawLines(int height){
	for (int i=0;i<height;i++){
		super.draw();
		}
	}
	
	@Override
	public void draw() {
		drawLines(getLength());
	}
	
	

}
