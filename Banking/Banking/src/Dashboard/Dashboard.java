package Dashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Dashboard {
	Scanner sc =new Scanner(System.in);
	
private String pass;
private String Account_number;
private String adhaar_card_number;
private String mobile_number ;
String username1;
public void home(String username) throws ClassNotFoundException, SQLException {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","123456");	
	String sq = "select * from registration where username='"+username+"'";
	Statement st = con.createStatement();
boolean	a =st.execute(sq);
	ResultSet rs = st.executeQuery(sq);
	//String pass="";
	
	
	  while(rs.next()) {
	  
	  username1 = rs.getString(1); 
	  adhaar_card_number=rs.getString(9);
	  mobile_number=rs.getString(5);
	  
	  }
	 
	
	System.out.println("  <<<<<<<<<<<<<<<< Hello "+username1+" >>>>>>>>>>>>>>>>");
	
}
public void check_blance() {
	System.out.println("Enter your Account Number âœ�");
	Account_number=sc.next();
	System.out.println("Enter your Password âœ�");
	pass=sc.next();
}
public void gen_acc() throws ClassNotFoundException, SQLException {
	

	String acc_number=adhaar_card_number.substring(0,7) +mobile_number .substring(0,7);
	System.out.println();
	System.out.println("  âž¡ Your  Account number is "+acc_number);
}
/*
 * public String getUser_name() { return user_name; } public void
 * setUser_name(String user_name) { this.user_name = user_name; } public String
 * getPass() { return pass; } public void setPass(String pass) { this.pass =
 * pass; } public String getAccount_number() { return Account_number; } public
 * void setAccount_number(String account_number) { this.Account_number =
 * account_number; }
 * 
 * public String getAdhaar() { return Adhaar; } public void setAdhaar(String
 * adhaar) { this.Adhaar = adhaar; } public String getMobile() { return mobile;
 * } public void setMobile(String mobile) { this.mobile = mobile; } public
 * Dashbord(String user_name, String pass, String mobile, String adhaar) {
 * super(); this.user_name = user_name; this.pass = pass; this.mobile = mobile;
 * 
 * this.Adhaar = adhaar; }
 */
}
