
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import Account.Account;
import Account.Bankblance;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Scanner;

import Dashboard.Dashboard;

import Loan.Loan;
import Loan.Loan_backend;
import Offer.Offers;
import Recharge.Recharge;
import Support.Support;
import wallate.Wallet;

public class Main {
public void home() throws Exception{
Registration reg = new Registration();
		int exit1;
		String First_name = "", last_name = "", userName = "", password = "", re_pass = "", mobile_No = "", email = "",
				address = "", pancard = "", adhaar_card = "", acc_type = "", gender = "", occupation = "";

		Scanner sc = new Scanner(System.in);
		System.out.println("     ********************   Welcome To MyBank   ********************      ");
		System.out.println();
		boolean Back_option = false;
		do {
			System.out.printf("   ->  1. Registration   \n  \n   ->  2. Login ");
			int ch = sc.nextInt();
			sc.nextLine();
			switch (ch) {
			case 1:
				System.out.println("Enter your First Name :");
				First_name = sc.nextLine();
				System.out.println("Enter your Last  Name :");
				last_name = sc.nextLine();
				System.out.println("Enter your userName  :");
				userName = sc.nextLine();
				boolean u = reg.usernameExists(userName);
				while (!u) {
					System.out.println("Sorry! username already taken");
					System.out.println("Enter your userName  :");
					userName = sc.nextLine();
					u = reg.usernameExists(userName);
				}

				System.out.println("Congrats! username is available");

				System.out.println("Enter your password :");
				password = sc.nextLine();
				System.out.println("Enter your Re_enter password :");
				re_pass = sc.nextLine();
				while (!password.equals(re_pass)) {
					System.out.println("Password does not match.");
					System.out.println("Enter your password :");
					password = sc.nextLine();
					System.out.println("Enter your Re_enter password :");
					re_pass = sc.nextLine();

				}
				System.out.println("Enter your Mobile Number :");
				mobile_No = sc.nextLine();
				boolean temp = true;
				while (temp) {
					System.out.println("Enter your Email :");
					email = sc.nextLine();
					if (!email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
						System.out.println("Enter valid email");
					} else
						temp = false;

				}
				System.out.println("Enter your Address :");
				address = sc.nextLine();
				System.out.println("Enter your Pancard :");

				pancard = sc.nextLine();

				System.out.println("Enter your Adhaar Card :");
				adhaar_card = sc.nextLine();
				System.out.println("Select your  Account :");
				System.out.printf("           -> 1. Saving   \n           -> 2. Current ");
				int acc_ch = sc.nextInt();
				switch (acc_ch) {
				case 1:
					acc_type = "Saving";

					break;
				case 2:
					acc_type = "Current";
					break;
				default:
					System.out.println("          *******   Select valid options    *******        ");
					break;
				}
				System.out.println("Select your  Gender :");
				System.out.printf("  -> 1. Male  \n  -> 2. Female   \n  -> 3. Transgender");
				int gen_ch = sc.nextInt();
				switch (gen_ch) {
				case 1:
					gender = "Male";
					break;
				case 2:
					gender = "Female";
					break;
				case 3:
					gender = "Trangender";
					break;
				default:
					System.out.println("  -> 1. Exit");
					exit1 = sc.nextInt();
					if (exit1 == 1) {
						Back_option = true;
					}
					System.out.println("          **********    Select valid options     **********        ");
					break;
				}
				System.out.println("Enter your Occupation :");
				occupation = sc.next();
				reg.registration(First_name, last_name, userName, password, mobile_No, email, address, pancard,
						adhaar_card, acc_type, gender, occupation);

				System.out.println("Registration Successful! Welcome to MyBank");
				System.out.println();
				System.out.println("  -> 1. Exit");
				exit1 = sc.nextInt();
				if (exit1 == 1) {
					Back_option = true;
				}
				break;
			// registration is done
			// login function
			case 2:
				System.out.println();
				System.out.println("Enter your UserName :");
				userName = sc.next();
				System.out.println("Enter your password :");
				password = sc.next();

				boolean v = reg.login(userName, password);
				// System.out.println(v);
				if (v) {

					System.out.println("Successful login");
					// dashboard
					System.out.println();
					Dashboard dash = new Dashboard();

					dash.home(userName);
					System.out.println();
					boolean temp1 = false;
					do {

						System.out.print(
								"  -> 1. Check Balance \n  -> 2. Get Account Number  \n  -> 3. Transfer Money  \n  -> 4. Bills & Recharges \n  -> 5. Wallet \n  -> 6. Loan \n  -> 7. Offers \n  -> 8. Support   \n  -> 9. Logout ");
						System.out.println();
						int ch1 = sc.nextInt();
						int exit;
						Offers of = new Offers();
						switch (ch1) {

						case 1:
							Bankblance b1 = new Bankblance();
							System.out.println("Enter your UserName :");
							userName = sc.next();
							b1.balance(userName);
							System.out.println();
							System.out.println("  -> 1. Exit");
							exit = sc.nextInt();
							if (exit == 1) {
								temp1 = true;
							}
							break;
						case 2:

							dash.gen_acc();
							System.out.println();
							System.out.println("  -> 1. Exit");
							exit = sc.nextInt();
							if (exit == 1) {
								temp1 = true;
							}
							break;
						case 3:

							Date d = new Date();
							Account acc = new Account();
							Random rd = new Random();
							// checks for money in sender's account
							int senderAccountBalance = acc.senderMoneyStatus("yash123");
							if (senderAccountBalance < 500)
								System.out.println("Minimum account balance should be Rs.500");
							else {

								System.out.println("Enter amount :");
								int amount = Integer.parseInt(sc.next());
								if (senderAccountBalance < amount)
									System.out.println("Insufficient account balance");
								else {
									// Money is deducted from sender's account
									acc.SendMoney(senderAccountBalance, amount, "yash123");
									// Recipient's Name
									System.out.println("Enter receiver's Name");
									String receiverName = sc.next();
									// Receiver's account number
									System.out.println("Enter account number:");
									String accountNumber = sc.next();
									// Checks the status of money in receiver's account
									int receiverAccountBalance = acc.receiverMoneyStatus(accountNumber);
									// Adds money in receiver's account

									int transfer = acc.receiveMoney(accountNumber, amount, receiverAccountBalance);

									if (transfer == 1) {
										System.out.println("Transaction successful");
										String day_date_time = d.toString();
										int transaction_id = (rd.nextInt(65536) - 32768);
										acc.addTransaction("yash123", day_date_time, amount, accountNumber,
												receiverName, transaction_id, "success");
									} else {
										System.out.println("Transaction failed");
									}

								}
							}

							System.out.println();
							System.out.println("  -> 1. Exit");
							exit = sc.nextInt();
							if (exit == 1) {
								temp1 = true;
							}
							break;
						case 4:
							Recharge re = new Recharge();
							re.recharge("yash123");
							System.out.println();
							System.out.println("  -> 1. Exit");
							exit = sc.nextInt();
							if (exit == 1) {
								temp1 = true;
							}
							break;
						case 6:

							System.out.printf(
									"   ->  1. Car Loan \n   -> 2. Home loan  \n   -> 3. Education Loan  \n   -> 4. Gold Loan  ");
							int ch3 = sc.nextInt();
							Loan obj3 = new Loan();
							System.out.println();
							Loan_backend loan = new Loan_backend();
							switch (ch3) {

							case 1:
								System.out.println("Enter your Adhaar Card :");
								adhaar_card = sc.next();
								System.out.println("Enter your Pancard :");
								pancard = sc.next();
								obj3.car_loan(adhaar_card, pancard,userName);
								//System.out.println(obj3.car_loan(adhaar_card, pancard,userName));
								// boolean a = obj3.car_loan(adhaar_card, pancard);
								// System.out.println(a);

								boolean a = obj3.car_loan(adhaar_card, pancard,userName);
								if (a == true) {
									System.out.println();
									System.out.printf("  -> 1. Proceed    \n  ->  2. Cancel");
									int ch4 = sc.nextInt();
									switch (ch4) {
									case 1:
										System.out.println("Enter your UserName :");
										userName = sc.next();
										System.out.println("Enter Your Bank Account number");
										String account = sc.next();
										System.out.println("Enter  Loan Amount :");
										int amount = Integer.parseInt(sc.next());
										System.out.println("Enter Your Loan Time Duration :");
										int time = Integer.parseInt(sc.next());
										loan.loan_store(userName, account, amount, time);
										System.out.println("  -> 1. Exit");
										exit = sc.nextInt();
										if (exit == 1) {
											temp1 = true;
										}
										break;
									case 2:
										System.out.println("  -> 1. Exit");
										exit = sc.nextInt();
										if (exit == 1) {
											temp1 = true;
										}
									}
								}

								else {
									System.out.println();
									System.out.println(" Hello " + userName + " Your Document's are not Correct ");
									System.out.println("  -> 1. Exit");
									exit = sc.nextInt();
									if (exit == 1) {
										temp1 = true;
									}
								}

								break;
							case 2:
								System.out.println();
								System.out.println("Enter your Adhaar Card :");
								adhaar_card = sc.next();
								System.out.println("Enter your Pancard :");
								pancard = sc.next();
								obj3.home_loan(adhaar_card, pancard,userName );
								a = obj3.home_loan(adhaar_card, pancard,userName);
								if (a == true) {
									System.out.println();
									System.out.printf("-> 1. Proceed    \n  ->  2. Cancel");
									int ch4 = sc.nextInt();
									switch (ch4) {
									case 1:
										System.out.println("Enter your UserName :");
										userName = sc.next();
										System.out.println("Enter Your Bank Account number");
										String account = sc.next();
										System.out.println("Enter  Loan Amount :");
										int amount = Integer.parseInt(sc.next());
										System.out.println("Enter Your Loan Time Duration :");
										int time = Integer.parseInt(sc.next());
										loan.loan_store(userName, account, amount, time);
										System.out.println("  -> 1. Exit");
										exit = sc.nextInt();
										if (exit == 1) {
											temp1 = true;
										}
										break;
									case 2:
										System.out.println("  -> 1. Exit");
										exit = sc.nextInt();
										if (exit == 1) {
											temp1 = true;
										}
									}
								} else {
									System.out.println();
									System.out.println(" Hello " + userName + " Your Document's are not Correct ");

									System.out.println("  -> 1. Exit");
									exit = sc.nextInt();
									if (exit == 1) {
										temp1 = true;
									}

								}
								break;
							case 3:
								System.out.println();
								System.out.println("Enter your Adhaar Card :");
								adhaar_card = sc.next();
								System.out.println("Enter your Pancard :");
								pancard = sc.next();
								obj3.education_loan(adhaar_card, pancard,userName);
								a = obj3.car_loan(adhaar_card, pancard,userName);
								if (a == true) {
									System.out.printf("-> 1. Proceed    \n  ->  2. Cancel");
									int ch4 = sc.nextInt();
									switch (ch4) {
									case 1:
										System.out.println("Enter your UserName :");
										userName = sc.next();
										System.out.println("Enter Your Bank Account number");
										String account = sc.next();
										System.out.println("Enter  Loan Amount :");
										int amount = Integer.parseInt(sc.next());
										System.out.println("Enter Your Loan Time Duration :");
										int time = Integer.parseInt(sc.next());
										loan.loan_store(userName, account, amount, time);
										
										System.out.println("  -> 1. Exit");
										exit = sc.nextInt();
										if (exit == 1) {
											temp1 = true;
										}
										break;
									case 2:
										System.out.println("  -> 1. Exit");
										exit = sc.nextInt();
										if (exit == 1) {
											temp1 = true;
										}
									}
								} else {
									System.out.println();
									System.out.println(" Hello " + userName + " Your Document's are not Correct ");
								}
								break;
							case 4:
								System.out.println();
								System.out.println("Enter your Adhaar Card :");
								adhaar_card = sc.next();
								System.out.println("Enter your Pancard :");
								pancard = sc.next();
								obj3.Gold_loan(adhaar_card, pancard,userName);
								a = obj3.car_loan(adhaar_card, pancard,userName);
								if (a = true) {
									System.out.printf("-> 1. Proceed    \n  ->  2. Cancel");
									int ch4 = sc.nextInt();
									switch (ch4) {
									case 1:
										System.out.println("Enter your UserName âœ");
										userName = sc.next();
										System.out.println("Enter Your Bank Account number");
										String account = sc.next();
										System.out.println("Enter  Loan Amount :");
										int amount = Integer.parseInt(sc.next());
										System.out.println("Enter Your Loan Time Duration :");
										int time = Integer.parseInt(sc.next());
										loan.loan_store(userName, account, amount, time);
										
										System.out.println("  -> 1. Exit");
										exit = sc.nextInt();
										if (exit == 1) {
											temp1 = true;
										}
										break;
									case 2:
										temp1 = true;
										break;
									}
								}
								break;
							default:
								break;
							}
							break;

						case 7:
							System.out.printf("    -> 1. Loan offers  \n    -> 2.Bills & Recharges offers ");
							int ch6 = sc.nextInt();
							switch (ch6) {
							case 1:

								System.out.println("Enter the loan amount :");
								double loanamount = sc.nextDouble();
								of.interst(loanamount);
								System.out.println("  -> 1. Exit");
								exit = sc.nextInt();
								if (exit == 1) {
									temp1 = true;
								}
								break;
							case 2:
								of.Bills_offers();
								System.out.println("  -> 1. Exit");
								exit = sc.nextInt();
								if (exit == 1) {
									temp1 = true;
								}
								break;
							default:
								System.out.println("  -> 1. Exit");
								exit = sc.nextInt();
								if (exit == 1) {
									temp1 = true;
								}
								break;
							}

							break;
						case 8:
							System.out.printf("    -> 1. Email Support   \n    -> 2. Call Support ");
							int s = sc.nextInt();
							String firstName;
							String lastName;
							Support sup = new Support();
							switch (s) {
							case 1:

								String message;
								System.out.println("Enter your First Name :");
								firstName = sc.next();
								System.out.println("Enter your Last Name :");
								lastName = sc.next();
								System.out.println("Enter your Email :");
								email = sc.next();
								System.out.println("Enter your message :");
								message = sc.next();

								sup.userDetails(firstName, lastName, email, message);
								break;
							case 2:
								sup.Call();
								System.out.println("  -> 1. Exit");
								exit = sc.nextInt();
								if (exit == 1) {
									temp1 = true;
								}
								break;
							}
							break;
						case 5:
							Wallet wallet = new Wallet();
							Account acc1 = new Account();
							//Scanner sc = new Scanner(System.in);
							
							int walletBalance=wallet.showWalletBalance("yash123");
							System.out.println(walletBalance);
							
							System.out.println("Do you want to add money?(y/n)");
							char ch11 = sc.next().charAt(0) ;
							
							System.out.println("Enter amount:");
							int amount = Integer.parseInt(sc.next());
							
							//checking status of money in bank account
							int moneyStatus = acc1.senderMoneyStatus("yash123");
							
							//Add Money in wallet
							if(moneyStatus<amount)
								System.out.println("insufficient balance");
							else
							{	acc1.SendMoney(moneyStatus, amount, "yash123");
								int result =wallet.addMoney("yash123",amount,walletBalance);
								
								if(result==1)
									System.out.println("Money added successfully");
								else
									System.out.println("Something went wrong!");
							}
							System.out.println("  -> 1. Exit");
							exit = sc.nextInt();
							if (exit == 1) {
								temp1 = true;
							}
							break;
                                                 case 9:
                                                  home();
                                                 break;
						default:
							System.out.println("  => 1. Exit");
							exit = sc.nextInt();
							if (exit == 1) {
								temp1 = true;
							}
							System.out.println("          ********   Select valid options   ********        ");
							break;
						}
					} while (temp1);
				} else {
					System.out.println("Forget Your Password :");
					System.out.printf("        ->  1. Yes   \n        ->  2. No  ");

					int f_ch = sc.nextInt();
					switch (f_ch) {
					case 1:
						System.out.println("Enter your UserName :");
						userName = sc.next();
						Forget_Password fg = new Forget_Password();

						fg.forget(userName);

						System.out.println("  -> 1. Exit");
						exit1 = sc.nextInt();
						if (exit1 == 1) {
							Back_option = true;
						}
						break;
					case 2:
						Back_option = true;
						break;
					default:
						System.out.println("  -> 1. Exit");
						exit1 = sc.nextInt();
						if (exit1 == 1) {
							Back_option = true;
						}
						System.out.println("          **********   Select valid options    **********        ");
						break;
					}
				}
				break;

			default:
				System.out.println("  -> 1. Exit");
				exit1 = sc.nextInt();
				if (exit1 == 1) {
					Back_option = true;
				}
				System.out.println("          **********   Select valid options    **********        ");
				break;
			}

		} while (Back_option);
	
}

	public static void main(String[] args) throws Exception {
              Main obj =new Main();
             obj.home();		
 	}

}

	


