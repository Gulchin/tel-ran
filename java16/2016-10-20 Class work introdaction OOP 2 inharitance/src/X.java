/*
 * Дз - написать классы WageEmploye(получает еще почасовую ставку) extands Employe и 
 * SalesPerson (также получает % от продаж) extends WageEmploye Manager extends Emploee (получает прибавку от степени коэффициент)
 * Каждому добавить соответствующие поля и переопределить методо computeSallary
 */
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

	public int computeX() {
		return xi;
	}
	
	

}
