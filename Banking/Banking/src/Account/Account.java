package Account;
import java.sql.*;
public class Account {
	public void SendMoney(int accountBalance,int amount,String username) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","123456");
		String sql = "Update account set AccountBalance=? where username='"+username+"'";
		PreparedStatement st = con.prepareStatement(sql);
		accountBalance=accountBalance-amount;
		st.setInt(1,accountBalance);
		st.executeQuery();
		st.close();
		con.close();		
	}
	
	public int senderMoneyStatus(String username) throws Exception{
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
		return accountBalance;
	}
	
	public int receiverMoneyStatus(String accountNumber) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","123456");
		Statement st = con.createStatement();
		String sql = "select * from account where accountNumber='"+accountNumber+"'";		
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
		return accountBalance;
	}
	public int receiveMoney(String accountNumber,int amount,int accountBalance) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","123456");
		String sql = "update account set AccountBalance=? where accountNumber='"+accountNumber+"'";
		PreparedStatement st = con.prepareStatement(sql);
		accountBalance = accountBalance + amount;
		st.setInt(1, accountBalance);
		int transfer = st.executeUpdate();
		st.close();
		con.close();	
		return transfer;
	}
	
	public void addTransaction(String username,String Day_Date_Time,int amount,String accountNumber,String recipient,int transaction_id,String transaction_status) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","123456");
		String sql = "insert into transaction values(?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, username);
		st.setString(2, Day_Date_Time);
		st.setInt(3,amount);
		st.setString(4, accountNumber);
		st.setString(5, recipient);
		st.setInt(6, transaction_id);
		st.setString(7, transaction_status);
		st.executeQuery();
		st.close();
		con.close();
	}
	
}
