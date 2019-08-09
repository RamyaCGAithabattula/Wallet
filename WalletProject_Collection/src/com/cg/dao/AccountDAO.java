package com.cg.dao;
import java.util.*;
import com.cg.bean.*;;

public interface AccountDAO {
public boolean addAccount(Account ob);
public boolean updateAccount(Account ob);
public boolean deleteAccount(Account ob);
public Account findAccount(long mobileno);
public Map<Long,Account> getAllAccounts(); 
}
