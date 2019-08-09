package com.cg.inputFormats;

public class TranserFundFormat {

	private int id1;
	private int id2;
	private double amount;
	
	public TranserFundFormat() {
		
	}
	
	public TranserFundFormat(int id1, int id2, double amount) {
		super();
		this.id1 = id1;
		this.id2 = id2;
		this.amount = amount;
	}

	public int getId1() {
		return id1;
	}

	public void setId1(int id1) {
		this.id1 = id1;
	}

	public int getId2() {
		return id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
