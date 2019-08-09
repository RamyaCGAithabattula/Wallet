package com.cg.service;

import java.util.Map;

import com.cg.bean.Account;
import com.cg.dao.*;
import com.cg.exception.InsufficientFundException;

public class AccountService  implements Gst,Transaction{ //Alternate to multiple inheritance

	AccountDAO dao=new AccountDAOImpl();
	public double withdraw(Account ob, double amount)throws InsufficientFundException {
		// TODO Auto-generated method stub
		double new_balance=ob.getBalance()-amount;
		if(new_balance<1000.00) {
					new_balance=ob.getBalance();
					//System.out.println("Insufficient Balance");
					throw new InsufficientFundException("Insufficient Fund, Cannot Process Withdrawl",new_balance);
				}
				ob.setBalance(new_balance);
				return new_balance;
				//dao.updateAccount();
	}

	@Override
	public double deposit(Account ob, double amount) {
		// TODO Auto-generated method stub
		double new_balance=ob.getBalance()+amount;
		ob.setBalance(new_balance);
		return new_balance;
	}

	@Override
	public String transferMoney(Account from, Account to, double amount) {// INCOMPLETE
		// TODO Auto-generated method stub
		double new_balance=from.getBalance()-amount;
		if(new_balance<1000.00) {
			//new_balance=from.getBalance();
			System.out.println("Insufficient Balance");
			//from.setBalance(new_balance);
			return "Amount cannot be transfered insufficient balance";
		}
		from.setBalance(new_balance);
		double b2=to.getBalance()+amount;
		to.setBalance(b2);
		String ans="From Account: "+from.getAid()+" Balance: "+from.getBalance()+"\n"+"To Account: "+to.getAid()+" Balance "+to.getBalance();
		return ans;
	}

	@Override
	public double calculateTax(double PCT, double amount) {
		// TODO Auto-generated method stub
		System.out.println(amount*Gst.PCT_5);
		return amount*Gst.PCT_5;
	}

	@Override
	public boolean addAccount(Account ob) {
		// TODO Auto-generated method stub
		return dao.addAccount(ob);
	}

	@Override
	public boolean deleteAccount(Account ob) {
		// TODO Auto-generated method stub
		return dao.deleteAccount(ob);
	}

	@Override
	public Account findAccount(long mobileno) {
		// TODO Auto-generated method stub
		return dao.findAccount(mobileno);
	}

	@Override
	public Map<Long, Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return dao.getAllAccounts();

	}

}