package Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bankblance {
	public void balance(String username) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","123456");
		Statement st = con.createStatement();
		String sql = "select * from account where username='"+username+"'";		
		ResultSet rs = st.executeQuery(sql);
		int accountBalance=0;
		while(rs.next()) {
			rs.getString(1);
			rs.getString(2);
			accountBalance = rs.getInt("AccountBalance");
			
		}
		
		rs.close();
		st.close();
		con.close();
		System.out.println(" Hi  "+ username  +"  Your account Balance is : "+accountBalance); 
	}
}
