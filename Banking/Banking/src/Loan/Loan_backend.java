package Loan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Loan_backend {
 String username ;
 String Account_number;
 int Emi ;
 int amount;
 
 
 
public void loan_store(String username,String AccountNumber ,int Amount,int  EMI) throws ClassNotFoundException, SQLException {
	double	totalamount = 0;
	double emi=0;
	if(EMI==6) {
    
	double	interest = Amount * (0.06);
		totalamount =Amount + interest;
	emi =(totalamount/EMI);
	}
	if(EMI==12) {
		double	interest = Amount * (0.08);
		totalamount =Amount + interest;
	emi =(totalamount/EMI);
	}
	if(EMI==18) {
		double	interest = Amount * (0.1);
		totalamount =Amount + interest;
	    emi =(totalamount/EMI);
	}
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","123456");
	String sql = "insert into loan values(?,?,?,?)";
	PreparedStatement st = con.prepareStatement(sql);
	st.setString(1, username);
	st.setString(2, AccountNumber);
	st.setLong(3, (long) totalamount);
	st.setLong(4, (long) emi);
	st.executeQuery();
	String sql1 = "Update account set AccountBalance=? where username='"+username+"'";
	PreparedStatement st1 = con.prepareStatement(sql1);
	Amount   =Amount+amount;
	st.setInt(1,Amount);
	st.executeQuery();
    System.out.println("Your Loan amount is add in your account");
}
}
