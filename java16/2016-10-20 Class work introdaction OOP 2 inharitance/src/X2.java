
public class X2 extends X {
private int x2i;

public X2(int xi, String xs, Y y, int xi2) {
	super(xi, xs, y);
	this.x2i = xi2;
}

public int getXi2() {
	return x2i;
}

@Override
public String toString() {
	return "X2 [xi2=" + x2i + ", toString()=" + super.toString() + "]";
}

@Override
public boolean equals(Object other){
	if (!super.equals(other))
		return false;
	X2 x2=(X2) other;
	return this.x2i==x2.x2i;
}

@Override
public int computeX(){
	return super.computeX()*x2i;
}
	
}
