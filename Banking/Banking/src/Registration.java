
import java.sql.*;
public class Registration {



	public void registration(String firstName,String lastName,String username,String password,String mobileNumber,String email,String address,String panNumber, String adhaarNumber,String account,String gender,String occupation) throws Exception {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","123456");			
			
			String sql = "insert into registration values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, firstName);
			st.setString(2, lastName);
			st.setString(3, username);
			st.setString(4, password);
			st.setString(5, mobileNumber);
			st.setString(6, email);
			st.setString(7, address);
			st.setString(8,panNumber);
			st.setString(9,adhaarNumber);
			st.setString(10, account);
			st.setString(11, gender);
			st.setString(12, occupation);
			st.executeQuery();
			st.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

		public boolean login(String username,String password) throws Exception {
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","123456");			
			//System.out.println(con);	
		String sq = "select * from registration where username='"+username+"'";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sq);
		String pass="";
		while(rs.next()) {
		
			rs.getString(1);
			rs.getString(2);
			rs.getString(3);
			
			pass = rs.getString(4);
		}
		rs.close();
		st.close();
		con.close();
	
		if(pass.equals(password))
			return true;
		else
			return false;
		
		
	}
		public boolean usernameExists(String username) throws Exception {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","123456");
			Statement st = con.createStatement();
			String sql = "select * from registration where username='"+username+"'";
			 int i = st.executeUpdate(sql);
			 if(i==1)
				 return false;
			 else
				 return true;
			
		}
	}
