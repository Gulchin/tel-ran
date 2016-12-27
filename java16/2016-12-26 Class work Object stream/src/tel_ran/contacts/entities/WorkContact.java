package tel_ran.contacts.entities;

public class WorkContact extends Contact {
CompanyInfo companyInfo;

public WorkContact(String phone, String name, String mail, Address address, CompanyInfo companyInfo) {
	super(phone, name, mail, address);
	this.companyInfo = companyInfo;
}

public CompanyInfo getCompanyInfo() {
	return companyInfo;
}

@Override
public String toString() {
	return "WorkContact [companyInfo=" + companyInfo + ", phone=" + phone + ", name=" + name + ", mail=" + mail
			+ ", address=" + address + "]";
}

}
