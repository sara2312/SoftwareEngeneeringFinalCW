package sa02386_coursework;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;



public class Test1 {
@Test
	public void testPaymentsDAOobject() {
		
		PaymentsDAO payments = new PaymentsDAO();
		System.out.println(payments.getPayments());
		System.out.println(payments.CalculateAveragePayement());
		System.out.println(payments.getAllPayementsGreaterThanTwiceTheAverage());
		
	}
	@Test
	public void compareDirectSQLQueryResultToMethodResult() {
		try {
			String databaseURL ="jdbc:mysql://localhost:3306/classicmodels?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow";
			Connection databaseConnection = DriverManager.getConnection(databaseURL, "root","mamanetpapa");
			String query = " SELECT * FROM payments WHERE amount>(SELECT avg(amount)*2 FROM payments)";
			Statement st = databaseConnection.createStatement();
			ResultSet directQueryResult = st.executeQuery(query);
			StringBuffer result = new StringBuffer();
			result.append(" the payements Greater Than Twice The Average are: " + "\n");
			while(directQueryResult.next()) {
				result.append(directQueryResult.getInt("customerNumber") + " " + directQueryResult.getDate("paymentDate") + " " + directQueryResult.getDouble("amount")+ "\n");
				
			}
			
			PaymentsDAO paymentsTest = new PaymentsDAO();
			assertEquals(paymentsTest.getAllPayementsGreaterThanTwiceTheAverage(), result.toString());
			
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	

}
