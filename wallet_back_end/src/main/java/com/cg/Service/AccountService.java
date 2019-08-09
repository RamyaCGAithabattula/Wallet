package com.cg.Service;

import java.util.List;

import com.cg.entities.Account;
//import com.cg.exception.InsufficientFundException;

public interface AccountService {

	public boolean addAccount(Account a);
	public boolean deleteAccount(Account a) ;
	public Account findAccount(int id) ;
	public List<Account> getAllAccounts();
	public void update(int id, Account account);
	
	public double withdraw(Account a,double amount);
	public double deposit(Account a,double amount);
	public double[] transferMoney(Account from, Account to, double amount);
	
}
