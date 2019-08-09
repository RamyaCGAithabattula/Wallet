package com.cg.dao;
import java.util.*;

import com.cg.bean.*;
public class AccountDAOImpl implements AccountDAO {

	static Map<Long,Account> acc=new HashMap<Long,Account>();
	
	@Override
	public boolean addAccount(Account ob) {
		// TODO Auto-generated method stub
		acc.put(ob.getMobile(),ob);
		return true;
	}

	@Override
	public boolean updateAccount(Account ob) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteAccount(Account ob) {
		// TODO Auto-generated method stub
		acc.remove(ob.getMobile());
		return true;
	}

	@Override
	public Account findAccount(long mobileno) {
		// TODO Auto-generated method stub
		Account ob=acc.get(mobileno);
		
		return ob;
	}

	@Override
	public Map<Long, Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return acc;
	}
	//transfermoney();

}
