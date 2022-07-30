package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Bank;

public class BankDAOImpl implements BankDAO {
	public static List<Bank> originalList = new ArrayList<Bank>();
	public static List<Bank> tempList = new ArrayList<Bank>();
	Scanner sc = new Scanner(System.in);
	Bank bank = null;
	int count = 0;
	@Override
	public void addAccount() {
		int n = 1;
		while (n == 1) {
			int balance = 0;
			bank = new Bank();
			System.out.println("Enter Account number");
			bank.setAccountNumber(sc.nextLong());
			System.out.println("Enter Account holder name");
			bank.setAccountHolderName(sc.next());
			// bank.setAccountHolderName("BHAVYASRI");in the place of my name I
			// can use "Scanner" also ex:sc.next()
			System.out.println("Enter Mobile number");
			bank.setMobileNumber(sc.nextLong());
			bank.setBalance(balance);
			System.out.println("If you want to add more accounts then only press 1 else any number");
			n = sc.nextInt();
			originalList.add(bank);
		}
		System.out.println("Account added sucessfully....");
	}

	@Override
	public Bank searchAccount() {
		Bank bank = new Bank();
		long accountNumber=sc.nextLong();
		for (Bank searchAccount : originalList) {
			if (searchAccount.getAccountNumber() == accountNumber) {
				bank = searchAccount;
				break;
			}
		}
		return bank;
	}

	@Override
	public List<Bank> viewAllAccounts() {
		return originalList;
	}

	@Override
	public void deleteAccount() {
		tempList = new ArrayList<Bank>();
		long accountNumber1 = sc.nextLong();
		for (Bank accountNumber : originalList) {
			if (accountNumber.getAccountNumber()==accountNumber1) {

			} else {
				tempList.add(accountNumber);
			}
		}
		originalList = new ArrayList<Bank>();
		for (Bank accountNumber : tempList) {
			originalList.add(accountNumber);
		}
		System.out.println("Account deleted sucessfully....");
	}

	@Override
	public void back() {
		BankManagementSystem(null);
	}

	private void BankManagementSystem(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void savingsAccount() {
			int n = 1;
			while (n == 1) {
				bank = new Bank();
				System.out.println("your account type is:savings account");
				System.out.println("enter account name");
				bank.setAccountHolderName(sc.next());
				System.out.println("enter account number");
				bank.setAccountNumber(sc.nextInt());
				System.out.println("enter mobile number");
				bank.setMobileNumber(sc.nextLong());
				System.out.println("Do you want to add more products press 1 else any number");
				n = sc.nextInt();
				originalList.add(bank);
				System.out.println("total accounts you have added " + (++count));
			}

		}

	@Override
	public void currentAccount() {
			int n = 1;
			while (n == 1) {
				bank = new Bank();
				
				//Bank bank1=new Bank(1234,"sr",7689,1000);
				
				System.out.println("your account type is:current account");
				System.out.println("enter account name");
				bank.setAccountHolderName(sc.next());
				System.out.println("enter account number");
				bank.setAccountNumber(sc.nextLong());
				System.out.println("enter mobile number");
				bank.setMobileNumber(sc.nextLong());
				System.out.println("Do you want to add more accounts press 1 else any number");
				n = sc.nextInt();
				originalList.add(bank);
				
				//originalList.add(bank1);
				
				System.out.println("total accounts you have added " + (++count));
			}
			System.out.println("account added successfully");
		}

	
	/*

	*/

	public void deposit() {
	
		System.out.println("enter account number");
		long accountNumber = sc.nextLong();

		tempList = new ArrayList<Bank>();
		for (Bank updateAccount : originalList) {
			if (updateAccount.getAccountNumber() == accountNumber) {
				System.out.println("enter the money you want to deposit");
				int money = sc.nextInt();
				double balance = updateAccount.getBalance() + money;

				updateAccount.setBalance((int) balance);
			}
			tempList.add(updateAccount);
		}
		originalList = new ArrayList<Bank>();
		for (Bank updateAccount : tempList) {
			originalList.add(updateAccount);
		}
	}

	public void withDraw() {
		System.out.println("enter account number");
		long accountNumber = sc.nextLong();
		tempList = new ArrayList<Bank>();
		for (Bank updateAccount : originalList) {
			if (updateAccount.getAccountNumber() == accountNumber) {
				System.out.println("enter the money you want to withdraw");
				int money = sc.nextInt();
				double balance = updateAccount.getBalance();
				balance -= money;
				updateAccount.setBalance((int) balance);
			}
			tempList.add(updateAccount);
		}
		originalList = new ArrayList<Bank>();
		for (Bank updateAccount : tempList) {
			originalList.add(updateAccount);
		}
	}

	public void getBalance() {
		System.out.println("enter account number");
		long accountNumber = sc.nextLong();
		for (Bank updateAccount : originalList) {
			if (updateAccount.getAccountNumber() == accountNumber) {
				System.out.println(updateAccount.getBalance());
			}
		}
	}

}
