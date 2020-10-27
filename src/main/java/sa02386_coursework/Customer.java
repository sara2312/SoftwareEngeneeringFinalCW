package sa02386_coursework;

public class Customer {
	private int customerNumber = 0;
	private String customerName = null;
	private String contactLastName = null;
	private String contactFirstName = null;
	private String phone = null;
	private String adressLine1 = null;
	private String adressLine2 = null;
	private String city = null;
	private String sate = null;
	private String postalCode = null;
	private String contry = null;
	private int salesRepEmployeeNumber = 0;
	private double creditLimit = 0;
	public int numberOfOrdersOnHold = 0;
	
	public Customer(int customerNumber, String customerName, String contactLastName, String contactFirstName,
			String phone, String adressLine1, String adressLine2, String city, String sate, String postalCode,
			String contry, int salesRepEmployeeNumber, double creditLimit) {
		super();
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
		this.phone = phone;
		this.adressLine1 = adressLine1;
		this.adressLine2 = adressLine2;
		this.city = city;
		this.sate = sate;
		this.postalCode = postalCode;
		this.contry = contry;
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
		this.creditLimit = creditLimit;
	}

	public int getCustomerNumber() {
		return this.customerNumber;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public String getContactLastName() {
		return this.contactLastName;
	}

	public String getContactFirstName() {
		return this.contactFirstName;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getAdressLine1() {
		return this.adressLine1;
	}

	public String getAdressLine2() {
		return this.adressLine2;
	}

	public String getCity() {
		return this.city;
	}

	public String getSate() {
		return this.sate;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public String getContry() {
		return this.contry;
	}

	public int getsalesRepEmployeeNumber() {
		return this.salesRepEmployeeNumber;
	}

	public double getCreditLimit() {
		return this.creditLimit;
	}
	
	
	

}
