package tel_ran.sapes;

public class Rectangle extends Square {
private int height;

public Rectangle(char symbol, int length, int height) {
	super(symbol, length);
	this.height = height;
}

@Override
public void draw() {
	drawLines(height);
}

}
