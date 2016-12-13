package tel_ran.sapes;
/*
 * All System.out.ptint() calls should be inside the base class;
 */
public  class Shape {
private char symbol;

public char getSymbol() {
	return symbol;
}

public Shape(char symbol) {
	super();
	this.symbol = symbol;
}

private void drawSymbol(char c){
	System.out.print(c);	
}

protected void drawSymbol(){
	drawSymbol(symbol);
}

public static void nextLine(){
	System.out.println();
}

protected void drawLine(char symbol, int length){
	for (int i=0;i<length;i++){
		drawSymbol(symbol);
	}
}

protected void drawLine(int length){
	drawLine(symbol, length);
}

public void draw(){
	drawSymbol();
	nextLine();
}
}
