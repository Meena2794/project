package automationexercise;

import java.util.Date;

public class bookingPojo {
private String firstname;	
private String lastname;		
private Number totalprice;	
private Boolean depositpaid;	
bookingdates dateobj;
private String additionalneeds;	


public bookingPojo() {}

public bookingPojo(String firstname, String lastname, Number totalprice, Boolean depositpaid, bookingdates dateobj,
		String additionalneeds) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.totalprice = totalprice;
	this.depositpaid = depositpaid;
	this.dateobj = dateobj;
	this.additionalneeds = additionalneeds;
}






public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public Number getTotalprice() {
	return totalprice;
}

public void setTotalprice(Number totalprice) {
	this.totalprice = totalprice;
}

public Boolean getDepositpaid() {
	return depositpaid;
}

public void setDepositpaid(Boolean depositpaid) {
	this.depositpaid = depositpaid;
}

public bookingdates getDateobj() {
	return dateobj;
}

public void setDateobj(bookingdates dateobj) {
	this.dateobj = dateobj;
}

public String getAdditionalneeds() {
	return additionalneeds;
}

public void setAdditionalneeds(String additionalneeds) {
	this.additionalneeds = additionalneeds;
}






class bookingdates{
	
	private	Date checkin;
	private	Date checkout;
	public bookingdates() {}
	
	public bookingdates(Date checkin, Date checkout) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public Date getCheckin() {
		return checkin;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	

}
}
