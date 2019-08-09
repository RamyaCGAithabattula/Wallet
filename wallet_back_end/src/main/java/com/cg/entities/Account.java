package com.cg.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accountsbhanu")
public class Account {
	
	@Id
	private Integer id;
	
	@Column(length=10)
	private String phone;
	
	@Column(length=30)
	private String accountHolder;
	
	@Column
	private double balance;
	
	public Account() {
	
	}

	public Account(Integer id,String phone, String accountHolder, double balance) {
		super();
		this.id = id;
		this.phone = phone;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer aid) {
		this.id = aid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", phone=" + phone + ", accountHolder=" + accountHolder + ", balance=" + balance + "]";
	}
	
}