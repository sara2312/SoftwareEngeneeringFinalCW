package sa02386_coursework;

import java.sql.Date;

public class Order {
	private int orderNumber = 0;
	private Date orderDate = null;
	private Date requiredDate = null;
	private Date shippedDate = null;
	private String status = null;
	private String comments = null;
	private int customerNumber = 0;
	
	public Order(int orderNumber, Date orderDate ,Date requieredDate, Date shippedDate, String status, String comments, int customerNumber)  {
		
			this.orderNumber = orderNumber;
			this.orderDate = orderDate;
			this.requiredDate = requieredDate;
			this.shippedDate = shippedDate;
			this.status = status;
			this.comments = comments;
			this.customerNumber = customerNumber;
		
	}

	public int getOrderNumber() {
		return this.orderNumber;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public Date getRequiredDate() {
		return this.requiredDate;
	}

	public Date getShippedDate() {
		return this.shippedDate;
	}

	public String getStatus() {
		return this.status;
	}

	public String getComments() {
		return this.comments;
	}

	public int getCustomerNumber() {
		return this.customerNumber;
	}
	
	
	

}
