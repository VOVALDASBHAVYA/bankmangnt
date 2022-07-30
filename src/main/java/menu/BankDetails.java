package menu;

import java.util.List;
import java.util.Scanner;

import dao.BankDAOImpl;
import model.Bank;

public class BankDetails {
		static Scanner sc = new Scanner(System.in);
		static BankDAOImpl dao = new BankDAOImpl();

		public static void adminMainMenu() {
			System.out.println("--------------------------");
			System.out.println("|    ADMIN MAIN MENU     |");
			System.out.println("--------------------------");
			System.out.println("|   1. ADD ACCOUNT       |");
			System.out.println("|   2. SEARCH ACCOUNT    |");
			System.out.println("|   3. VIEW ALL ACCOUNTS |");
			System.out.println("|   4. DELETE ACCOUNT    |");
			System.out.println("|   5. BACK              |");
			System.out.println("--------------------------");
			System.out.println("Enter Your Choice ?");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				dao.addAccount();
				adminMainMenu();
				break;
			case 2:
				System.out.println("Enter Search Account number ?");
				Bank searchAccount = dao.searchAccount();
				System.out.println("Acc.No : " + " \t " + "Acc.Holder Name : " + " \t " + "Mobile No : " + " \t " + "Balance:");
				System.out.println("------------------------------");
				System.out.println(searchAccount);
				//dao.searchAccount();
				adminMainMenu();
				break;
			case 3:
				List<Bank> bank = dao.viewAllAccounts();
				System.out.println("Acc.No : " + " \t " + "Acc.Holder Name : " + " \t " + "Mobile No : " + " \t " + "Balance:");
				System.out.println("------------------------------");
				for (Bank viewAllAccounts : bank) {
					System.out.println(viewAllAccounts);
				}
				adminMainMenu();
				break;
			case 4:
				System.out.println("Which Account do you want to delete ?");
				dao.deleteAccount();
				adminMainMenu();
				break;
			case 5:
				dao.back();
				break;
			default:
				System.out.println("Please select your choice range 1-5 only");
			}
		}

		public static void customerMainMenu() {
			System.out.println("--------------------------");
			System.out.println("|  CUSTOMER MAIN MENU     |");
			System.out.println("--------------------------");
			System.out.println("|   1. DEPOSIT MONEY      |");
			System.out.println("|   2. WITHDRAW MONEY     |");
			System.out.println("|   3. CHECK BALANCE      |");
			System.out.println("|   4. BACK               |");
			System.out.println("--------------------------");
			System.out.println("Enter Your Choice ?");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("--------------------------");
				System.out.println("|   ACCOUNT TYPE MENU    |");
				System.out.println("--------------------------");
				System.out.println("|    1. SAVINGS ACCOUNT  |");
				System.out.println("|    2. CURRENT ACCOUNT  |");
				System.out.println("--------------------------");
				System.out.println("Please select your Account type");
				int choice1 = sc.nextInt();
				switch (choice1) {
				case 1:
					System.out.println("Welcome to Savings Account !");
					 
					 System.out.println("Acc.No:" + " \t " +" "+ "Acc.Holder Name:" + " \t "+" " + "Mobile No:" + " \t "+" " + "Balance:");
					 System.out.println("------------------------------");
					 dao.deposit();
					break;
				case 2:
					System.out.println("Welcome to Current Account !");
					 System.out.println("Acc.No:" + " \t " +" "+"Acc.Holder Name:" + " \t "+" " + "Mobile No:" + " \t " +" "+ "Balance:");
					 System.out.println("------------------------------");
					dao.deposit();
					break;
				}
				
			case 2:
				System.out.println("--------------------------");
				System.out.println("|   ACCOUNT TYPE MENU    |");
				System.out.println("--------------------------");
				System.out.println("|    1. SAVINGS ACCOUNT  |");
				System.out.println("|    2. CURRENT ACCOUNT  |");
				System.out.println("--------------------------");
				System.out.println("Please select your Account type");
				int choice2 = sc.nextInt();
				switch (choice2) {
				case 1:
					System.out.println("Welcome to Savings Account !");
					 
					 System.out.println("Acc.No:" + " \t " +" "+ "Acc.Holder Name:" + " \t "+" " + "Mobile No:" + " \t "+" " + "Balance:");
					 System.out.println("------------------------------");
					 dao.withDraw();
					break;
				case 2:
					System.out.println("Welcome to Current Account !");
					 System.out.println("Acc.No:" + " \t " +" "+"Acc.Holder Name:" + " \t "+" " + "Mobile No:" + " \t " +" "+ "Balance:");
					 System.out.println("------------------------------");
					dao.withDraw();
					break;
					}
				customerMainMenu();
					break;
			case 3:
				dao.getBalance();
				customerMainMenu();
				break;
			case 4:
				dao.back();
				break;
			default:
				System.out.println("Please select your choice range 1-4 only");

			}

		}


	}
