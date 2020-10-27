package sa02386_coursework;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class OrdersDAO {
	private List<Order> orders = null;
	
	public OrdersDAO() {
		super();
		this.orders = new ArrayList<Order>();
		BaseQuery ordersQuery = new BaseQuery("root" ,"");
		try {
			ResultSet orders = ordersQuery.useTable("orders");
			while(orders.next()) {
				Order tmpOrder = new Order(orders.getInt("orderNumber"), orders.getDate("orderDate"), orders.getDate("requiredDate"), orders.getDate("shippedDate"), orders.getString("status"),
						orders.getString("comments"), orders.getInt("customerNumber") );
				this.orders.add(tmpOrder);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getOrdersOnHoldForEachCustomer() {
		StringBuffer ordersOnHold = new StringBuffer();
		StringBuffer resultReturned = new StringBuffer();
		CustomerDAO customersToCheckOrderStatus = new CustomerDAO();
		for(Customer customer : customersToCheckOrderStatus.getCustomers() ) {
			//int numberOfOrdersOnHold = 0;
			ordersOnHold.append("The customer  " + customer.getCustomerNumber()+" "  + customer.getCustomerName()
			+" has ");
			//int numberOfOrdersOnHold = 0;
			for(Order order: this.getOrders()) {
				
				if(order.getCustomerNumber() == customer.getCustomerNumber() )
						//&& order.getStatus().equals("On Hold")) {
				{ if(order.getStatus().equals("On Hold")) {
					 customer.numberOfOrdersOnHold++;}
					
				}
			}
			ordersOnHold.append(customer.numberOfOrdersOnHold + " orders on hold." + "\n");
			System.out.println(ordersOnHold .toString());
			if(customer.numberOfOrdersOnHold >0) {
				resultReturned.append( customer.getCustomerName() + " " + customer.numberOfOrdersOnHold + "\n");
			}
		}
		
		
		return  resultReturned.toString();
	
	}

	public List<Order> getOrders() {
		return this.orders;
	}
	
	

}
