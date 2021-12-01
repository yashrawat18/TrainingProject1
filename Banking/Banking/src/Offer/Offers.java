package Offer;

import java.util.Scanner;

public class Offers {
	Scanner sc = new Scanner(System.in);

	public double interest;
	public double loanamount;
	public double totalamount;

	public void interst(double loanamount) {
		interest = loanamount * (0.12);
		totalamount = (loanamount + interest);
		System.out.println("Your total amount to be paid =Rs. " + totalamount);
		System.out.println(
				"***Offers Available***\n1)Pay total money in 6 months with 6% interest\n2)Pay total money in 12 months with 8% interest\n3)Pay total money in 18 months with 10% interest");
		System.out.println("Enter Offer Type");
		int type = sc.nextInt();
		if (type == 1) {
			interest = loanamount * (0.06);
			totalamount = loanamount + interest;
			System.out.println("Your total amount to be paid =Rs. " + totalamount);
		} else if (type == 2) {
			interest = loanamount * (0.08);
			totalamount = loanamount + interest;
			System.out.println("Your total amount to be paid =Rs. " + totalamount);
		} else if (type == 3) {
			interest = loanamount * (0.1);
			totalamount = loanamount + interest;
			System.out.println("Your total amount to be paid =Rs. " + totalamount);
		} else {
			System.out.println("Offer not available");
		}

	}

	public void Bills_offers() {

		System.out.println(
				"***Offers Available***\n1)2% cashback if amount transfer is more than 10000\n2)4% cashback if amount transfer is more than 20000\n3)8% cashback if amount transfer is more than 30000");
		

		System.out.println("Enter amount to be transferred");
		double Amt = sc.nextDouble();
		if (Amt > 10000 && Amt <= 20000) {
			System.out.println("**Congratulations**\nYou are eligible for 2% cashback");
			double cback = Amt * (0.02);
			
			System.out.println("Your cashback amount = " + cback);
		} else if (Amt > 20000 && Amt <= 30000) {
			System.out.println("**Congratulations**\nYou are eligible for 4% cashback");
			double cback = Amt * (0.04);
			
			System.out.println("Your cashback amount = " + cback);
		} else if (Amt > 30000) {
			System.out.println("**Congratulations**\nYou are eligible for 8% cashback");
			double cback = Amt * (0.08);
			
			System.out.println("Your cashback amount = " + cback);
		} else {
			System.out.println("**No Cashback is available for you**");
		}

	}

}