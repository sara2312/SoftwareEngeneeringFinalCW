package sa02386_coursework;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
public class Product {
	private String productCode = null;
	private String productName = null;
	private String productLine = null;
	private String productScale = null;
	private String productVendor = null;
	private String productDescription = null;
	private int quantityInStock =0;
	private double buyPrice = 0;
	private double MSRP =0;
	
	
	public Product(String productCode,String productName,String productLine,String productScale,
			String productDescription,String productVendor,int quantityInStock,double buyPrice, double MSRP)throws NullPointerException {
		
		super();
		
		
		
		
			this.productCode = productCode;
			this.productName = productName;
			this.productLine = productLine;
			this.productScale = productScale;
			this.productVendor = productVendor;
			this.productDescription = productDescription;
			this.quantityInStock = quantityInStock;
			this.buyPrice = buyPrice;
			this.MSRP = MSRP;
		
	}


	public String getProductCode() {
		return this.productCode;
	}


	public String getProductName() {
		return this.productName;
	}


	public String getProductLine() {
		return this.productLine;
	}


	public String getProductScale() {
		return this.productScale;
	}


	public String getProductVendor() {
		return this.productVendor;
	}


	public String getProductDescription() {
		return this.productDescription;
	}


	public int getQuantityInStock() {
		return this.quantityInStock;
	}


	public double getBuyPrice() {
		return this.buyPrice;
	}


	public double getMSRP() {
		return this.MSRP;
	}
	
	
	
	
}
