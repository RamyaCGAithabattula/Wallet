package com.cg.dao;

import java.util.*;

import com.cg.bean.Account;
import com.cg.exception.InsufficientFundException;

public interface AccountDAO {

	//public boolean getConnection();
	public boolean addAccount(Account ob);
	public boolean updateAccount(long mobile,String ah);
	public boolean deleteAccount(long mobile);
	public Account findAccount(long mobile);
	public Map<Long,Account> getAllAccounts();
	public void transferMoney(long from, long to, double amount) throws InsufficientFundException;
	public boolean deposit(long mobile,double amount);
	public boolean withdraw(long mobile,double amount) throws InsufficientFundException;
	public void exit();
	
	
	
	
}
