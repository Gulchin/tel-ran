
public class Y {
	private int y;

	public int getY() {
		return y;
	}

	private void setY(int y) {
		this.y = y;
	}

	public Y(int y) {
		super();
		setY(y);
	}

	@Override
	public String toString() {
		return "Y [y=" + y + "]";
	}


	@Override
	public boolean equals(Object obj) {
		Y yobj=(Y)obj;
		return this.y==yobj.y;
	}
	
	

}
