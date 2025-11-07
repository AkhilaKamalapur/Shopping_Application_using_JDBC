package com.Shopping.main;

import java.util.Scanner;

import com.Shopping.service.AdminService;
import com.Shopping.service.CustomerService;
import com.sun.xml.internal.fastinfoset.util.CharArray;
import com.sun.xml.internal.fastinfoset.util.CharArrayArray;

public class Main 
{
	public static void main(String[] args) throws InterruptedException {
		CustomerService customerservice=new CustomerService();
		AdminService adminservice=new AdminService();
		
		Scanner scanner=new Scanner(System.in);
		String st="****----****Welcome to A14_Shopping****----****";
		char ch[]=st.toCharArray();
		for(int i=0;i<=ch.length-1;i++)
		{
			System.out.print(ch[i]);
			Thread.sleep(100);
		}
		boolean status=true;
		while(status)
		{
		System.out.println("Enter \n 1.Admin Login \n 2.Customer Registration \n 3. Customer Login  ");
		switch (scanner.nextInt()) {
		case 1:
			System.out.println(" Admin Login.");
			adminservice.adminLogin();
			break;
		case 2:
			System.out.println(" Customer Registration.");
			customerservice.customerRegistration();
			break;
		case 3:
			System.out.println(" Customer Login.");
			customerservice.customerLogin();
//			customerservice.customerOperations();
			break;
		default:
			System.out.println("Invalid Reguest");
			break;
		}
		System.out.println("Do you want to continue 😊😊😊 Enter");
		System.out.println("1.yes");
		System.out.println("2.No");
		String option=scanner.next();
		if(option.equalsIgnoreCase("yes")) {
			status=true;
		}else
		{
			System.out.println("Exited successfully...");
			 System.out.println("Thank you Visit Again....😊😊");
			 status=false;		
		}	
		}
	}
}
