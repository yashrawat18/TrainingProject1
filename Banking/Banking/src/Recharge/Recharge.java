package Recharge;


import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import Account.Account;
import wallate.Wallet;
public class Recharge {
	public void recharge(String username) throws Exception {
		Wallet wallet = new Wallet();
		Account acc =  new Account();
		Date d = new Date();
		Random rd = new Random();		
		int gasBillNumber,waterBillNumber,electricityBillNumber,amount,accountBalance,walletBalance,transaction_id;
		char ch1;
		String day_date_time,mobileNumber;
		System.out.println("Recharge:\n 1.Mobile\n 2.Gas Bill\n 3.Water Bill\n 4.Electricity Bill");
		
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);
		switch(ch) {
		case '1':System.out.println("Enter mobile number");
				  mobileNumber = sc.next();
				 System.out.println("Enter amount:");
				 amount = Integer.parseInt(sc.next());
				 System.out.println("Pay from:\n 1.wallet\n 2.Account");
				  ch1 = sc.next().charAt(0);
				 if(ch1=='1') {
					 walletBalance = wallet.showWalletBalance(username);
					 accountBalance = acc.senderMoneyStatus(username);
					 if(walletBalance<amount) {
						 System.out.println("Insufficient Balance");
						 int remainingAmount = amount-walletBalance;
						 System.out.println("Would you like to add Rs."+remainingAmount+"?(y/n)");
						 ch1 = sc.next().charAt(0);
						 if(ch1=='y' && accountBalance>500) {							 
							 acc.SendMoney(accountBalance, remainingAmount, username);
							 wallet.addMoney(username, remainingAmount, walletBalance);
							 walletBalance = wallet.showWalletBalance(username);
							 wallet.payMoney(username, amount, walletBalance);
							 System.out.println("Money Added Successfully");
							 System.out.println("Mobile Recharge Successful");
							 day_date_time = d.toString();
							 transaction_id=(rd.nextInt(65536)-32768);
							 acc.addTransaction("yash123",day_date_time,amount,"1002003444","Reliance Jio",transaction_id,"success");
						 }
						 else {
							System.out.println("Transaction cancelled");
							System.out.println("Account balance: "+accountBalance);			
							break;
						 }
							 
					 }
					 else
					 {
						 wallet.payMoney(username, amount, walletBalance);
						 System.out.println("Mobile Recharge Successful");
						 day_date_time = d.toString();
						 transaction_id=(rd.nextInt(65536)-32768);
						 acc.addTransaction("yash123",day_date_time,amount,"1002003444","Reliance Jio",transaction_id,"success");
					 
					 }
				 }
				 else {
					 accountBalance = acc.senderMoneyStatus(username);					 
					 if(accountBalance<amount)
						 System.out.println("insufficient Balance");
					 else
					 {
						 acc.SendMoney(accountBalance, amount, username);
						 System.out.println("Mobile Recharge Successful");
						 day_date_time = d.toString();
						 transaction_id=(rd.nextInt(65536)-32768);
						 acc.addTransaction("yash123",day_date_time,amount,"1002003444","Reliance Jio",transaction_id,"success");
					 
					 }
				 }
				 break;
		case '2' : 
			System.out.println("Enter Bill number");
			  gasBillNumber = sc.nextInt();
			 System.out.println("Enter amount:");
			 amount = sc.nextInt();
			 System.out.println("Pay from:\n 1.wallet\n 2.Account");
			  ch1 = sc.next().charAt(0);
			 if(ch1=='1') {
				 walletBalance = wallet.showWalletBalance(username);
				 accountBalance = acc.senderMoneyStatus(username);
				 if(walletBalance<amount) {
					 System.out.println("Insufficient Balance");
					 int remainingAmount = amount-walletBalance;
					 System.out.println("Would you like to add Rs."+remainingAmount+"?(y/n)");
					 ch1 = sc.next().charAt(0);
					 
					 if(ch1=='y' && accountBalance>500) {							 
						 acc.SendMoney(accountBalance, remainingAmount, username);
						 wallet.addMoney(username, remainingAmount, walletBalance);
						 walletBalance = wallet.showWalletBalance(username);
						 wallet.payMoney(username, amount, walletBalance);
						 System.out.println("Money Added Successfully");
						 System.out.println("Bill Paid Successfully");
						 day_date_time = d.toString();
						 transaction_id=(rd.nextInt(65536)-32768);
						 acc.addTransaction("yash123",day_date_time,amount,"3456789999","Indane",transaction_id,"success");
					 
					 }
					 else {
						System.out.println("Transaction cancelled");
						System.out.println("Account balance: "+accountBalance);						
						break;
					 }
						 
				 }
				 else
				 {
					 wallet.payMoney(username, amount, walletBalance);
					 System.out.println("Bill Paid Successfully");
					 day_date_time = d.toString();
					 transaction_id=(rd.nextInt(65536)-32768);
					 acc.addTransaction("yash123",day_date_time,amount,"3456789999","Indane",transaction_id,"success");
				 
				 }
			 }
			 else {
				 accountBalance = acc.senderMoneyStatus(username);					 
				 if(accountBalance<amount)
					 System.out.println("insufficient Balance");
				 else
				 {
					 acc.SendMoney(accountBalance, amount, username);
					 System.out.println("Bill Paid Successfully");
					 day_date_time = d.toString();
					 transaction_id=(rd.nextInt(65536)-32768);
					 acc.addTransaction("yash123",day_date_time,amount,"3456789999","Indane",transaction_id,"success");
				 
				 }
			 }
			 break;
		 
		 
		case '3':
			System.out.println("Enter Bill number");
			  waterBillNumber = sc.nextInt();
			 System.out.println("Enter amount:");
			 amount = sc.nextInt();
			 System.out.println("Pay from:\n 1.wallet\n 2.Account");
			  ch1 = sc.next().charAt(0);
			 if(ch1=='1') {
				 walletBalance = wallet.showWalletBalance(username);
				 accountBalance = acc.senderMoneyStatus(username);
				 if(walletBalance<amount) {
					 System.out.println("Insufficient Balance");
					 int remainingAmount = amount-walletBalance;
					 System.out.println("Would you like to add Rs."+remainingAmount+"?(y/n)");
					 ch1 = sc.next().charAt(0);
					 
					 if(ch1=='y' && accountBalance>500) {							 
						 acc.SendMoney(accountBalance, remainingAmount, username);
						 wallet.addMoney(username, remainingAmount, walletBalance);
						 walletBalance = wallet.showWalletBalance(username);
						 wallet.payMoney(username, amount, walletBalance);
						 System.out.println("Money Added Successfully");
						 System.out.println("Bill Paid Successfully");
						 day_date_time = d.toString();
						 transaction_id=(rd.nextInt(65536)-32768);
						 acc.addTransaction("yash123",day_date_time,amount,"9867767455","BMC",transaction_id,"success");
					 
					 }
					 else {
						System.out.println("Transaction cancelled");
						System.out.println("Account balance: "+accountBalance);
						break;
					 }
						 
				 }
				 else
				 {
					 wallet.payMoney(username, amount, walletBalance);
					 System.out.println("Bill Paid Successfully");
					 day_date_time = d.toString();
					 transaction_id=(rd.nextInt(65536)-32768);
					 acc.addTransaction("yash123",day_date_time,amount,"9867767455","BMC",transaction_id,"success");
				 
				 }
			 }
			 else {
				 accountBalance = acc.senderMoneyStatus(username);					 
				 if(accountBalance<amount)
					 System.out.println("insufficient Balance");
				 else
				 {
					 acc.SendMoney(accountBalance, amount, username);
					 System.out.println("Bill Paid Successfully");
					 day_date_time = d.toString();
					 transaction_id=(rd.nextInt(65536)-32768);
					 acc.addTransaction("yash123",day_date_time,amount,"9867767455","BMC",transaction_id,"success");
				 
				 }
			 }
			 break;
		case '4':
			System.out.println("Enter Bill number");
			  electricityBillNumber = sc.nextInt();
			 System.out.println("Enter amount:");
			 amount = sc.nextInt();
			 System.out.println("Pay from:\n 1.wallet\n 2.Account");
			  ch1 = sc.next().charAt(0);
			 if(ch1=='1') {
				 walletBalance = wallet.showWalletBalance(username);
				 accountBalance = acc.senderMoneyStatus(username);
				 if(walletBalance<amount) {
					 System.out.println("Insufficient Balance");
					 int remainingAmount = amount-walletBalance;
					 System.out.println("Would you like to add Rs."+remainingAmount+"?(y/n)");
					 ch1 = sc.next().charAt(0);
					 
					 if(ch1=='y' && accountBalance>500) {							 
						 acc.SendMoney(accountBalance, remainingAmount, username);
						 wallet.addMoney(username, remainingAmount, walletBalance);
						 walletBalance = wallet.showWalletBalance(username);
						 wallet.payMoney(username, amount, walletBalance);
						 System.out.println("Money Added Successfully");
						 System.out.println("Bill Paid Successfully");
						 day_date_time = d.toString();
						 transaction_id=(rd.nextInt(65536)-32768);
						 acc.addTransaction("yash123",day_date_time,amount,"29897871198","MPEB",transaction_id,"success");
					 
					 }
					 else {
						System.out.println("Transaction cancelled");
						System.out.println("Account balance: "+accountBalance);												
						break;
					 }
						 
				 }
				 else
				 {
					 wallet.payMoney(username, amount, walletBalance);
					 System.out.println("Bill Paid Successfully");
					 day_date_time = d.toString();
					 transaction_id=(rd.nextInt(65536)-32768);
					 acc.addTransaction("yash123",day_date_time,amount,"29897871198","MPEB",transaction_id,"success");
				 
				 }
			 }
			 else {
				 accountBalance = acc.senderMoneyStatus(username);					 
				 if(accountBalance<amount)
					 System.out.println("insufficient Balance");
				 else
				 {
					 acc.SendMoney(accountBalance, amount, username);
					 System.out.println("Bill Paid Successfully");
					 day_date_time = d.toString();
					 transaction_id=(rd.nextInt(65536)-32768);
					 acc.addTransaction("yash123",day_date_time,amount,"29897871198","MPEB",transaction_id,"success");
				 
				 }
			 }
			 break;
			
		}
		
	//	sc.close();
	}
}
