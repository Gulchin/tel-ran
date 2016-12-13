
public class X11 extends X1 {
	private int xi11;
	private int xi12;
	
	public X11(int xi, String xs, Y y, int xi1, int xi2, int xi11, int xi12) {
		super(xi, xs, y, xi1, xi2);
		this.xi11 = xi11;
		this.xi12 = xi12;
	}

	public int getXi11() {
		return xi11;
	}

	public int getXi12() {
		return xi12;
	}

	@Override
	public String toString() {
		return "X11 [xi11=" + xi11 + ", xi12=" + xi12 + ", toString()=" + super.toString() + "]";
	}
	
	
	@Override
	public boolean equals(Object other){
		if (!super.equals(other))
			return false;
		X11 x11=(X11)other;
		if (this.xi11!=x11.xi11)
			return false;
		if (this.xi12!=x11.xi12)
			return false;
		return true;
	}

	@Override
	public int computeX(){
		return super.computeX()+xi11*xi12/100;
	}
	

}
