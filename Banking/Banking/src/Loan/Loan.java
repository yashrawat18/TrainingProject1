package Loan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Loan {
	private String username;
	private String adhaar_card_number;
	private String mobile_number;
	private String pan_card_number;
	String adhaar_card_number1;
	String pancard1;

	public boolean car_loan(String adhaar_card_number, String pan_card_number,String username)
			throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "admin", "123456");
		String sq = "select * from registration where username='" + username + "'";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sq);

		while (rs.next()) {
			adhaar_card_number1 = rs.getString(9);
			pancard1 = rs.getString(8);
		}

		if (adhaar_card_number.equals(adhaar_card_number1) && pan_card_number.equals(pancard1)) {
			return true;
		}

		else {
			return false;
		}

	}

	public boolean home_loan(String adhaar_card_number, String pan_card_number,String username)
			throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "admin", "123456");
		String sq = "select * from registration where username='" + username + "'";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sq);

		while (rs.next()) {/*
			rs.getString(1);
			rs.getString(2);
			rs.getString(3);
			rs.getString(4);
			rs.getString(5);
			rs.getString(6);		*/
			
			pancard1 = rs.getString(8);
			adhaar_card_number1 = rs.getString(9);
		}
		System.out.println(adhaar_card_number1);
		if (adhaar_card_number.equals(adhaar_card_number1) && pan_card_number.equals(pancard1)) {
			return true;
		}

		else {
			return false;
		}
	}

	public boolean Gold_loan(String adhaar_card_number, String pan_card_number,String username)
			throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "admin", "123456");
		String sq = "select * from registration where username='" + username + "'";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sq);

		while (rs.next()) {
			adhaar_card_number1 = rs.getString(9);
			pancard1 = rs.getString(8);
		}
		System.out.println(adhaar_card_number1);
		System.out.println(adhaar_card_number);
		System.out.println(pancard1);
		System.out.println(pan_card_number);
		if (adhaar_card_number.equals(adhaar_card_number1) && pan_card_number.equals(pancard1)) {
			return true;

		}

		else {
			return false;
		}
	}

	public boolean education_loan(String adhaar_card_number, String pan_card_number,String username)
			throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "admin", "123456");
		String sq = "select * from registration where username='" + username + "'";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sq);

		while (rs.next()) {
			adhaar_card_number1 = rs.getString(9);
			pancard1 = rs.getString(8);
		}
		if (adhaar_card_number.equals(adhaar_card_number1) && pan_card_number.equals(pancard1)) {
			return true;
		}

		else {
			return false;
		}
	}
}
