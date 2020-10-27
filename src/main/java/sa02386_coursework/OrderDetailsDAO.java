package sa02386_coursework;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class OrderDetailsDAO {
	private List<OrderDetails> orderDetails = null;
	public OrderDetailsDAO() {
		super();
		this.orderDetails = new ArrayList<OrderDetails>();
		BaseQuery orderDetailsQuery = new BaseQuery("root","");
		try {
			ResultSet orderDetails = orderDetailsQuery.useTable("orderdetails");
			while(orderDetails.next()) {
				OrderDetails tmpOrderDetails = new OrderDetails(orderDetails.getInt("orderNumber"),orderDetails.getString("productCode"),orderDetails.getInt("quantityOrdered"), orderDetails.getDouble("priceEach"),orderDetails.getByte("orderLineNumber"));
				this.orderDetails.add(tmpOrderDetails);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public List<OrderDetails> getOrderDetails() {
		return this.orderDetails;
	}
	

}
