package sa02386_coursework;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Test2 {

	@Test
	public void test() {
		OrdersDAO orders = new OrdersDAO();
		System.out.println(orders.getOrdersOnHoldForEachCustomer());
		System.out.println(orders.getOrders());
	}
	@Test
	public void compareDirectQueryOutputTomethodsOutput() {
		String databaseURL ="jdbc:mysql://localhost:3306/classicmodels?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow";
		Connection databaseConnection;
		try {
			databaseConnection = DriverManager.getConnection(databaseURL, "root","mamanetpapa");
			String query = " SELECT customers.customerName,COUNT(orders.orderNumber) AS totalOrdersHold FROM (orders, customers) WHERE customers.customerNumber = orders.customerNumber AND orders.status = \"On Hold\" GROUP BY customers.customerName;";
			Statement st = databaseConnection.createStatement();
			ResultSet directQueryResult = st.executeQuery(query);
			StringBuffer result = new StringBuffer();
			while(directQueryResult.next()) {
				result.append(directQueryResult.getString("customerName")+" "+directQueryResult.getInt("totalOrdersHold")+ "\n");
			}
			OrdersDAO orders = new OrdersDAO();
			
			System.out.println(result.toString());
			    System.out.println(orders.getOrdersOnHoldForEachCustomer());
			    
			    //StringBuffer resultToCompare = new StringBuffer();
			//assertEquals(orders.getOrdersOnHoldForEachCustomer(), result.toString());
			    
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
