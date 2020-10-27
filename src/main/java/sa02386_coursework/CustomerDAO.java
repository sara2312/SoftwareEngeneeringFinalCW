package sa02386_coursework;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
public class CustomerDAO {
	private List<Customer> customers = null;
	
	public CustomerDAO() {
		this.customers = new ArrayList<Customer>();
		BaseQuery customersQuery = new BaseQuery("root","");
		
		try {
			ResultSet customers = customersQuery.useTable("customers");
			while(customers.next()) {
				Customer tmpCustomer = new Customer(customers.getInt("customerNumber"), customers.getString("customerName"),customers.getString("contactLastName"),customers.getString("contactFirstName"),customers.getString("phone"),customers.getString("addressLine1"),
						customers.getString("addressLine2"),customers.getString("city"),customers.getString("state"),customers.getString("postalCode"),customers.getString("country"), customers.getInt("salesRepEmployeeNumber"), customers.getDouble("creditLimit"));
				this.customers.add(tmpCustomer);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}
	
	

}
