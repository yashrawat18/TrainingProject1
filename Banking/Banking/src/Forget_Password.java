import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Forget_Password {
	String user,pass;
public boolean forget(String username) throws ClassNotFoundException, SQLException {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","123456");			
		//System.out.println(con);	
	String sq = "select * from registration where username='"+username+"'";
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(sq);
	String pass="";
	while(rs.next()) {
	
		user=rs.getString(3);
		pass=rs.getString(4);
//		rs.getString(3);
		
		pass = rs.getString(4);
	}
	if (username.equals(user)) {
		System.out.println(" ➡ Your Password is :"+pass);
		
		return true;	
	}
	else {
		
		System.out.println("Sorry UserName Not Match 2");
		return false;
		
	}
	
	
}
}
