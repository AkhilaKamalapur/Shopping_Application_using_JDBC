package com.Shopping.service;

import java.util.Scanner;

import com.Shopping.dao.AdminDAO;
import com.Shopping.dto.Admin;
import com.Shopping.dto.CustomerDetails;

public class AdminService 
{
	AdminDAO admindao=new AdminDAO();
	Scanner scanner=new Scanner(System.in);
	ProductService productSerivce=new ProductService();
	
	public void adminLogin() {
		System.out.println("enter the emailid or mobileno");
		String emailid=scanner.next();
		System.out.println("enter the password ");
		String password=scanner.next();
		Admin adminDetails=admindao.selectAdminByusingEmailorMobileNoAndPassword(emailid, password);
//		emailid.equalsIgnoreCase("admin1@gmail.com")&& password.equalsIgnoreCase("1234")
		if(adminDetails!=null)
		{
			System.out.println("enter \n 1. Insert product Details");
			switch(scanner.nextInt())
			{
			case 1:
				System.out.println("Insert product Details ");
				productSerivce.storeProductDetails();
				break;
			case 2:
				System.out.println("Insert product details based on brands  ");
				productSerivce.storeProductsByUsingBrand();
				break;
			
			default :
				System.out.println("Invalid Request");
				break;
			}


		}
		else
		{
			System.out.println("invalid emailid  or password");
		}
		
	}


}
