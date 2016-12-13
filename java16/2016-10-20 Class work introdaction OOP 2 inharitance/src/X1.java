
public class X1 extends X {
	
	private int xi1;
	private int xi2;

	
	
	public X1(int xi, String xs, Y y, int xi1, int xi2) {
		super(xi, xs, y);
		this.xi1 = xi1;
		this.xi2 = xi2;
	}



	public int getXi1() {
		return xi1;
	}



	public int getXi2() {
		return xi2;
	}



	@Override
	public String toString() {
		return "X1 [xi1=" + xi1 + ", xi2=" + xi2 + ", toString()=" + super.toString() + "]";
	}
	
	public boolean equals(Object other){
		if (!super.equals(other)) 
			return false;
		X1 x1=(X1) other;
		if(this.xi1!=x1.xi1) 
			return false;
		if(this.xi2!=x1.xi2) 
			return false;
		return true;
	}

	@Override
	public int computeX(){
		return super.computeX()+xi1*xi2;
		
	}
	

}
