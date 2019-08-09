package com.cg.service;

import java.util.ArrayList;
import java.util.Map;

import com.cg.bean.Account;
import com.cg.dao.AccountDAO;
import com.cg.dao.AccountDAOImpl;
import com.cg.exception.InsufficientFundException;

public class AccountService  implements Gst,Transaction,AccountOperation{ 
	AccountDAO dao=new AccountDAOImpl();

	@Override
	public double calculateTax(double PCT, double amount) {
		// TODO Auto-generated method stub
		return amount*Gst.PCT_5;
	}

	@Override
	public boolean addAccount(Account ob) {
		// TODO Auto-generated method stub
		return dao.addAccount(ob);
	}

	@Override
	public boolean updateAccount(long mobile,String ah) {
		// TODO Auto-generated method stub
		return dao.updateAccount(mobile,ah);
	}

	@Override
	public boolean deleteAccount(long mobile) {
		// TODO Auto-generated method stub
		return dao.deleteAccount(mobile);
	}

	@Override
	public Account findAccount(long mobile) {
		// TODO Auto-generated method stub
		return dao.findAccount(mobile);
	}

	@Override
	public Map<Long,Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return dao.getAllAccounts();
	}

	@Override
	public void transferMoney(long from, long to, double amount) throws InsufficientFundException {
		// TODO Auto-generated method stub
		dao.transferMoney(from, to, amount);
	}

	@Override
	public boolean deposit(long mobileno, double amount) {
		// TODO Auto-generated method stub
		return dao.deposit(mobileno, amount);
	}

	@Override
	public boolean withdraw(long mobile, double amount) throws InsufficientFundException {
		// TODO Auto-generated method stub
		return dao.withdraw(mobile, amount);
	}

	public void exit() {
		// TODO Auto-generated method stub
		dao.exit();
	}
	

}