package tel_ran.sapes;

public class SquareEmty extends Shape {

	private int width;
	
	public SquareEmty(char symbol, int width) {
		super(symbol);
		this.width = width;
	}

	protected void drawEmpty(int width,int height){
		drawLine(width);
		nextLine();
		for (int i=1;i<height-1;i++){
			drawSymbol();
			drawLine(' ', width-2);
			drawSymbol();
			nextLine();
		}
		drawLine(width);
		nextLine();				
	}
	
	@Override
	public void draw() {
		drawEmpty(width, width);		
	}

	public int getWidth() {
		return width;
	}
	

}
