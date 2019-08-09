package com.cg.service;

import java.util.Map;

import com.cg.bean.Account;

public interface AccountOperation {
	public boolean addAccount(Account ob);
	public boolean deleteAccount(Account ob);
	public Account findAccount(long mobileno);
	public Map<Long,Account> getAllAccounts();

}
