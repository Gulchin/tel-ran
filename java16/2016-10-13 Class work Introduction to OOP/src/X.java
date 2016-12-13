
public class X {
	private int xi;
	private String xs;
	// Если Y мютэбл, то Х тоже будет мютэбл
	private Y y;
	
	public X(int xi, String xs, Y y){
		this.xi=xi;
		this.xs=xs;
		this.y=y;
	}

	public int getXi() {
		return xi;
	}

	public String getXs() {
		return xs;
	}

	public Y getY() {
		return y;
	}

	@Override
	public String toString() {
		return "X [xi=" + xi + ", xs=" + xs + ", y=" + y + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		X x=(X)obj;
		
		return this.xi==x.xi && this.xs.equals(x.xs) && this.y.equals(x.y);
	}
	
	

}
