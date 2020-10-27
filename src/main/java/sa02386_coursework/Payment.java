package sa02386_coursework;

import java.sql.Date;

public class Payment {
private int customerNumber =0;
private String checkNumber = null;
private Date paymentDate = null;
private double amount = 0;

public Payment(int customerNumber, String checkNumber, Date paymentDate, double amount )  {
	super();
	
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount =amount;
	
}

public int getCustomerNumber() {
	return this.customerNumber;
}

public String getCheckNumber() {
	return this.checkNumber;
}

public Date getPaymentDate() {
	return this.paymentDate;
}

public double getAmount() {
	return this.amount;
}
@Override
public String toString() {
	StringBuffer payment = new StringBuffer();
	payment.append(this.getCustomerNumber() + " " + this.getPaymentDate() + " " + this.getAmount());
	return payment.toString();
}

}
