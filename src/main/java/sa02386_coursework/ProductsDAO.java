package sa02386_coursework;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductsDAO {
	private List <Product> products = null;
	
	public ProductsDAO() {
		super();
		this.products = new ArrayList<Product>();
		BaseQuery productQuery = new BaseQuery("root","");
		try {
			ResultSet products = productQuery.useTable("products");
			while(products.next()) {
				Product tmpProduct = new Product(products.getString("productCode"), products.getString("productName"), products.getString("productLine"),
						products.getString("productScale"), products.getString("productVendor"), products.getString("productDescription"), products.getInt("quantityInStock"), products.getDouble("buyPrice"), products.getDouble("MSRP") );
				this.products.add(tmpProduct);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public List<Product> getProducts() {
		return this.products;
	}
	
	
	public String getRevenueGeneratedByEachProduct() {
		
		StringBuffer revenueGeneratedByEachProduct = new StringBuffer();
		
		OrderDetailsDAO detailsOfAllTheOrders = new OrderDetailsDAO();
		
		for(Product product : this.getProducts() ) {
			
			revenueGeneratedByEachProduct .append(product.getProductName() + " has generated ");
			
			int quantityOrdered =0;
			double revenue = 0;
			
			for(OrderDetails order : detailsOfAllTheOrders.getOrderDetails() ) {
				
				if(order.getProductCode().equals(product.getProductCode())) {
					quantityOrdered += order.getQuantityOrdered();
				}
			}
			
			revenue = quantityOrdered* product.getBuyPrice();
			
			revenueGeneratedByEachProduct.append("£ "+ revenue+ " as a revenue"+"\n" );
			
		}
		return revenueGeneratedByEachProduct.toString();
	}
	

}
