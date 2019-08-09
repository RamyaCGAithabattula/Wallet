package com.cg.pl;
import java.io.*;
import java.util.*;
import com.cg.bean.*;
import com.cg.exception.*;
import com.cg.service.*;
import com.cg.dao.*;
public class MyWallet {

	public static void main(String[] args)throws IOException, InsufficientFundException {
		// TODO Auto-generated method stub
		AccountService service=new AccountService();
		Map<Long,Account> acc=new TreeMap<Long,Account>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String choice="";
		while(true)
		{
		System.out.println("Menu");
		System.out.println("=====");
		System.out.println("1 Create an Account");
		System.out.println("2 Print all accounts");
		System.out.println("3 Delete Account");
		System.out.println("4 Transfer To");
		System.out.println("5 Withdraw From");
		System.out.println("6 Deposit");
		System.out.println("7 Calculate Tax");
		System.out.println("8 Find acocunt");
		System.out.println("9 Exit");
		System.out.println("Enter your choice");
		choice=br.readLine();
		switch(choice)
		{
		case "1":	int id=0;
					long mb=0L;
					String ah="";
					double bal=0.0;
					//Accepting and validating input for account number
					System.out.println("Enter Account Number");
					while(true)
					{
						String s_id=br.readLine();
						boolean ch1=Validator.validatedata(s_id,Validator.aidpattern);
						if(ch1==true)
						{
							try {
								id=Integer.parseInt(s_id);
								break;
							}
							catch(NumberFormatException e)
							{
								System.out.println("Account Number must be numeric Re Enter");
							}
						}
						else
						{
							System.out.println("Re Enter Account Number in 3 digits");
						}
					}//End of Account number while
					
					//Accepting and validating input for mobile number
					
					System.out.println("Enter mobile number");
					while(true)
					{
						String s_mb=br.readLine();
						boolean ch1=Validator.validatedata(s_mb,Validator.mobilepattern);
						if(ch1==true)
						{
							try {
								mb=Long.parseLong(s_mb);
								break;
							}
							catch(NumberFormatException e)
							{
								System.out.println("Mobile Number must be numeric, Re Enter");
							}
						}
						else
						{
							System.out.println("Re Enter Mobile Number in 10 digits");
						}
					}//End of Mobile number while
					
					//Accepting and validating input for account holder name
					System.out.println("Enter account holder name");
					while(true)
					{
						String s_ah=br.readLine();
						boolean ch1=Validator.validatedata(s_ah,Validator.ahpattern);
						if(ch1==true)
						{
							try {
								ah=s_ah;
								break;
							}
							catch(NumberFormatException e)
							{
								System.out.println("Name must be alphabet, Re Enter");
							}
						}
						else
						{
							System.out.println("Re Enter name in alphabets");
						}
					}//End of account holder while
					//Accepting and validating input for account balance
					System.out.println("Enter balance");
					while(true)
					{
						String s_bal=br.readLine();
						boolean ch1=Validator.validatedata(s_bal,Validator.balpattern);
						if(ch1==true)
						{
							try {
								bal=Double.parseDouble(s_bal);
								break;
							}
							catch(NumberFormatException e)
							{
								System.out.println("Balance must be numeric, Re Enter");
							}
						}
						else
						{
							System.out.println("Re Enter balance greater than 0 in numeric");
						}
						
					}//End of account balance while
					Account ob=new Account(id,mb,ah,bal);
					acc.put(ob.getMobile(),ob);
					break;			
					
		case "2":	
					Collection<Account> vc=acc.values();
					List<Account> acclist=new ArrayList<Account>(vc);
					//Collections.sort(acclist);
	
					for(Account o:acclist)
					{
						//System.out.println(o);
						service.printStatement(o);
					}
					break;
					
		case "3":	
					System.out.println("Enter  Mobile number to delete");
					mb=Long.parseLong(br.readLine());
					acc.remove(mb);
					break;
					
		case "4":	
					System.out.println("Enter from account");
					long from=Long.parseLong(br.readLine());
					System.out.println("Enter to account");
					long to=Long.parseLong(br.readLine());
					System.out.println("Enter amount to transfer");
					double amount=Double.parseDouble(br.readLine());
					service.transferMoney(acc.get(from),acc.get(to),amount);
					break;
		case "5":	
					System.out.println("Enter mobile number");
					long mnum=Long.parseLong(br.readLine());
					service.printStatement(acc.get(mnum));
					System.out.println("Enter amount to withdraw");
					amount=Double.parseDouble(br.readLine());
					service.withdraw(acc.get(mnum), amount);
					break;
					
		case "6":	
					System.out.println("Enter mobile number");
					mnum=Long.parseLong(br.readLine());
					System.out.println("Enter amount ");
					amount=Double.parseDouble(br.readLine());
					service.deposit(acc.get(mnum), amount);
					break;
					
		case "7":	
					System.out.println("Enter amount on GST");
					amount=Double.parseDouble(br.readLine());
					service.calculateTax(0.05, amount);
					break;
					
		case "8":	
					System.out.println("Enter mobile to find account");
					mnum=Long.parseLong(br.readLine());
					service.findAccount(mnum);
					break;
					
		case "9":
					System.out.println("Exit Program");
					System.exit(0);
		default:	System.out.println("Invalid Choice");
		}
}//end of menu

		
		
		
		/*service.printStatement(ob2); //calling default method of Transaction 
		double b1=0.0;
		try
		{
			b1=service.withdraw(ob2, 55000.00);
			System.out.println("After Withdraw balance is: "+b1);
		}
		catch(InsufficientFundException e)
		{
			System.err.println(e.getMessage());
			System.err.println(e);
		}
		double tax=service.calculateTax(Gst.PCT_5, b1);
		System.out.println("Gst: "+tax);*/
		//create switch(case 1 accept input)
		//Account ob=new Account(inputs);
		//boolean b=service.addAccount(ob);
		//sop("successfully added"+b)
		//for case2,,,,,,Map<Long,Account> acc=service.getAllAccounts();
		
		
		
		
		
		//SavingAccount ob3=new SavingAccount(106,22262722,"Sahil",55000.00);
		//System.out.println(service.transferMoney(ob2, ob3, 10000));
		
		
		//System.out.println(ob2 instanceof SavingAccount);

		//System.out.println(ob2 instanceof Account);
		//System.out.println(ob2 instanceof Object);
		//System.out.println(ob2 instanceof String);//ERROR
		
		//Account ob3=new Account();// ABSTRACT CLASS CANNOT BE INSTANTIZED
		
	}

}