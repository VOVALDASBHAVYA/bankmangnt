package dao;
//main_bankmanagementsystem //menu_bankdetais
/***
 * here after creating the package I have to create & select interface & give name as BankDAO
 * again create one class in this package only and give name as BankDAOImpl and click on add, then select BankDAO
 */
import java.util.List; 

import model.Bank;

public interface BankDAO {
	public void addAccount();
	public Bank searchAccount();
	public List<Bank> viewAllAccounts();
	public void deleteAccount();
	public void back();
	public void savingsAccount();
	public void currentAccount();
	void getBalance();
	void withDraw();
	void deposit();
	
}
