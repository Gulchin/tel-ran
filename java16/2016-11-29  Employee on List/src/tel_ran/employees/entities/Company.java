package tel_ran.employees.entities;

public class Company {
	private String name;
	private String country;
	public Company(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public String getCountry() {
		return country;
	}
	@Override
	public String toString() {
		return String.format("company %s, registred in %s", name,country);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Company company=(Company)obj;
		return this.name.equals(company.name) && this.country.equals(company.country);
	}
	
	public int compareTo(Company company){
		int nameCompare=name.compareTo(company.name);
	  if(nameCompare!=0) return nameCompare;
	  return country.compareToIgnoreCase(company.country);
	}
	
	

}
