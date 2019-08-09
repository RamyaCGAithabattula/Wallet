package com.cg.exception;

public class InsufficientFundException extends Exception{
private double balance;
public InsufficientFundException(String msg,double balance) {
	// TODO Auto-generated constructor stub
	super(msg);
	this.balance=balance;
}
public InsufficientFundException() {
	// TODO Auto-generated constructor stub
	
}
@Override
public String toString() {
	return "InsufficientFundException [balance=" + balance + "]"+ super.getMessage();
} 

	

}
