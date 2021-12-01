package wallate;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Wallet {
	public int showWalletBalance(String username) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","123456");
		Statement st = con.createStatement();
		String sql = "select * from wallet where username='"+username+"'";
		ResultSet rs = st.executeQuery(sql);
		int walletBalance=0;
		while(rs.next()) {
			walletBalance=rs.getInt(3);
		}
		return walletBalance;
	}
	
	public int addMoney(String username,int amount,int walletBalance) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","123456");
		String sql ="update wallet set amount=? where username ='"+username+"'";
		PreparedStatement st = con.prepareStatement(sql);
		walletBalance = walletBalance + amount;
		st.setInt(1, walletBalance);
		int status = st.executeUpdate();
		return status;
	}
	
	public int payMoney(String username,int amount,int walletBalance) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","123456");
		String sql = "update wallet set amount=? where username='"+username+"'";
		PreparedStatement st = con.prepareStatement(sql);
		walletBalance = walletBalance-amount;
		st.setInt(1,walletBalance);
		int status = st.executeUpdate();
		return status;
	}
}
