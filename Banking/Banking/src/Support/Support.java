package Support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Support {

	public void userDetails(String firstName,String lastName,String email,String message) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","123456");
		String sql = "insert into support values(?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, firstName);
		st.setString(2, lastName);
		st.setString(3, email);
		st.setString(4, message);
		st.executeQuery();
		System.out.println("Your Query is submitted");
		st.close();
		con.close();
	}
public void Call() {
	
	System.out.printf(" \n Call Us :   7007224457  \n             7007223359  \n             9048374839");
}
}
