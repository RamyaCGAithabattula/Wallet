package com.cg.inputFormats;

public class DepositAndWithdraw {

	private int id;
	private double amount;
	
	public DepositAndWithdraw() {
		
	}
	
	public DepositAndWithdraw(int id, double amount) {
		super();
		this.id = id;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
