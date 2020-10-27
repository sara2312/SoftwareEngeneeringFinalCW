package sa02386_coursework;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentsDAO {
	
	//this class implements requirement 1 of set E
	
	private List <Payment> payments = null;
	
	PaymentsDAO(){
		super();
		this.payments = new ArrayList<Payment>();
		BaseQuery payementQuery = new BaseQuery("root" ,"");
		try {
			ResultSet payments = payementQuery.useTable("payments");
			while(payments.next()) {
				Payment TmpPayment = new Payment(payments.getInt("customerNumber"), payments.getString("checkNumber"), payments.getDate("paymentDate"),payments.getDouble("amount") );
				this.payments.add(TmpPayment);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public double CalculateAveragePayement() {
		double sum =0;
		double average = 0;
		for(Payment payment : this.payments) {
			sum += payment.getAmount();
		}
		average = sum / this.payments.size();
		return average;
	}
	public String getAllPayementsGreaterThanTwiceTheAverage() {
		
		StringBuffer payementsGreaterThanTwiceTheAverage = new StringBuffer();
		payementsGreaterThanTwiceTheAverage.append(" the payements Greater Than Twice The Average are: " + "\n");
		for(Payment payment : this.payments) {
			if(payment.getAmount() > (this.CalculateAveragePayement()*2)) {
				payementsGreaterThanTwiceTheAverage.append(payment.toString() + "\n");
			}
		}
		
		return payementsGreaterThanTwiceTheAverage.toString();
		
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	
	

}
