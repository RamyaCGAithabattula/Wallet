package com.cg.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.daos.AccountDAO;
import com.cg.entities.Account;
import com.cg.exception.ApplicationException;
//import com.cg.exception.InsufficientFundException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired AccountDAO dao; 
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addAccount(Account a) {
		if (dao.existsById(a.getId()))
			throw new ApplicationException("Account already exists!!"); // throwing custom exception if product already exists
		dao.save(a); 
		
		System.out.println("Account added to the database");
		return true;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteAccount(Account a) {
		if (!dao.existsById(a.getId()))
			throw new ApplicationException("Account doesn't exist!!"); // throwing custom exception if product doesn't exist
		else
			dao.delete(a);
		
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public Account findAccount(int id) {
		Optional<Account> a = dao.findById(id);
		if (a.isPresent()) 
			return a.get();
		else
			throw new ApplicationException("Account not found!"); // throwing custom exception if account doesn't exist
	}

	@Override
	@Transactional(readOnly = true)
	public List<Account> getAllAccounts() {
		return dao.findAll();
//		for(Account a: list)
//			System.out.println(a);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public double withdraw(Account ob, double amount) {
		double new_balance = ob.getBalance();
		if(amount > 0) {
			new_balance = ob.getBalance() - amount;
			if(new_balance < 1000.00) {
				new_balance = ob.getBalance();
				System.out.println("Insufficient Balance");
				//throw new InsufficientFundException("insufficient fund, can't process withdraw", new_balance);
				
			}
			else {
				ob.setBalance(new_balance);
				update(ob.getId(), ob);
			}
		}
		return ob.getBalance();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public double deposit(Account ob, double amount) {
		if(amount >= 0) {
			double new_balance = ob.getBalance() + amount;
			ob.setBalance(new_balance);
			
			update(ob.getId(), ob);
			
			return new_balance;
		}
		else {
			return ob.getBalance(); 
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public double[] transferMoney(Account from, Account to, double amount) {
		double[] arr = new double[2];
		if(amount < 0) {
			System.out.println("Invalid withdrawal..try again with positive amount");
			
			arr[0] = from.getBalance();
			arr[1] = to.getBalance();
			
		}
		else {
			double new_balance = from.getBalance() - amount;
			if(new_balance<1000.00) {
				
				System.out.println("Insufficient Balance");
				arr[0] = from.getBalance();
				arr[1] = to.getBalance();
				
			}
			else {
				from.setBalance(new_balance);
				arr[0] = from.getBalance();
				
				double b2 = to.getBalance()+amount;
				to.setBalance(b2);
				
				arr[1] = to.getBalance();
				
				update(from.getId(), from);
				update(to.getId(), to);
			}
		}
		return arr;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(int id, Account account) {
		Account a;
		Optional<Account> p = dao.findById(id);
		if (p.isPresent()) 
			a = p.get();
		else
			throw new ApplicationException("Account not found!"); // throwing custom exception if account doesn't exist
		
//		dao.delete(a);
//		dao.save(account);
		
		a.setAccountHolder(account.getAccountHolder());
		a.setBalance(account.getBalance());
		a.setId(account.getId());
		a.setPhone(account.getPhone());
	}

}
