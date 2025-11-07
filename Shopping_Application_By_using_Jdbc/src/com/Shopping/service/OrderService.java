package com.Shopping.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.Shopping.dao.OrderDAO;
import com.Shopping.dto.OrderDetails;

public class OrderService 
{
	OrderDAO orderdao=new OrderDAO();
	public void intoOrderDetails( int cid,int pid, String address,int quantity) {
		OrderDetails orderDetails=new OrderDetails();
		orderDetails.setCustomer_id(cid);
		orderDetails.setProduct_id(pid);
		orderDetails.setOrder_Address(address);
		orderDetails.setProduct_Quantity(quantity);
		orderDetails.setOrder_Date(LocalDate.now());
		if(orderdao.insertOrderDetails(orderDetails)) {
			System.out.println(orderDetails);
		}
		else
		{
			System.out.println("server error 500");
		}
		
	}

}
