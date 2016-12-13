package tel_ran.sapes;

public class LineVertically extends Line {

	public LineVertically(char symbol, int length) {
		super(symbol, length);
	}

	@Override
	public void draw() {
		int l=getLength();
		for (int i=0;i<l;i++){
			drawSymbol();
			nextLine();
		}
	}

}
