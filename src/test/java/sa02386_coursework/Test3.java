package sa02386_coursework;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class Test3 {

	@Test
	public void test() {
		ProductsDAO products = new ProductsDAO();
		System.out.println(products.getRevenueGeneratedByEachProduct());
		
	}
@Test
public void compareCodeOutputToDirectQuery() {
	String databaseURL ="jdbc:mysql://localhost:3306/classicmodels?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow";
	Connection databaseConnection;
	try {
		databaseConnection = DriverManager.getConnection(databaseURL, "root","mamanetpapa");
		String query = "SELECT sum(quantityOrdered*priceEach) AS revenue,products.productName,products.productCode FROM orderdetails,products WHERE orderdetails.productCode = products.productCode GROUP BY products.productCode; ";
		Statement st = databaseConnection.createStatement();
		ResultSet directQueryResult = st.executeQuery(query);
		StringBuffer result = new StringBuffer();
		while(directQueryResult.next()) {
			//product.getProductName() + "has generated "
					//"£ "+ revenue+ " as a revenue"+"\n"
			result.append(directQueryResult.getString("productName" +" has generated £ " + directQueryResult.getDouble("revenue")+ " as a revenue" + "\n"));
		}
		
		//System.out.println(result.toString());
		ProductsDAO products = new ProductsDAO();
		assertEquals(products.getRevenueGeneratedByEachProduct(), result.toString());
}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
