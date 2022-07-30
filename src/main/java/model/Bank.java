package model;
/*
 * this "bank class" is nothing but entity class
 * an entity is essentially an obj. wrapper for a DB Table.
 * the attributes of an entity are transformed to columns on the DB tabe.
 */

public class Bank {

		private long accountNumber;
		private String accountHolderName;
		private long mobileNumber;
		private int balance;
		public Bank() {
			//super();
		}
		public Bank(long accountNumber, String accountHolderName, long mobileNumber, int balance) {
			super();
			this.accountNumber = accountNumber;
			this.accountHolderName = accountHolderName;
			this.mobileNumber = mobileNumber;
			this.balance = balance;
		}
		public long getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(long accountNumber) {
			this.accountNumber = accountNumber;
		}
		public String getAccountHolderName() {
			return accountHolderName;
		}
		public void setAccountHolderName(String accountHolderName) {
			this.accountHolderName = accountHolderName;
		}
		public long getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(int balance) {
			this.balance = balance;
		}
		@Override
		public String toString() {
			return " " + accountNumber + " \t " + accountHolderName + " \t " + mobileNumber + " \t " + balance ;
			//return accountNumber + " \t " + accountHolderName + " \t " + mobileNumber + " \t " + balance ;

		}
		
		

}
