package com.Shopping.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.Shopping.dao.PaymentDAO;
import com.Shopping.dto.CustomerDetails;
import com.Shopping.dto.PaymentDetails;
import com.Shopping.dto.ProductDetails;

public class PaymentService 
{
	Scanner scanner=new Scanner(System.in);
	public boolean paymentProcessDetails(int cid,int pid,double Amount) {
		//u can give an arguments like (int id,double amount and int pid )
		PaymentDetails paymentDetails=new PaymentDetails();
//		paymentDetails.setCustomer_Id(cid.getCustomer_Id());
		paymentDetails.setAmount(Amount);
		paymentDetails.setPayment_Date(LocalDate.now());
		System.out.println("Enter \n 1.for UPI \n 2.Cash on Delivery \n 3.Debit \n 4. netpayment \n 5.EMI");
		switch(scanner.nextInt())
		{
		case 1: 
			paymentDetails.setPayment_type("UPI");
			paymentDetails.setPayment_Status("payment success");
			break;
		case 2:
			paymentDetails.setPayment_type("cash on delivery");
			paymentDetails.setPayment_Status("Under Processing");
			break;
		case 3:
			paymentDetails.setPayment_type("Debit");
			paymentDetails.setPayment_Status("payment success ");
			break;
		case 4: 
			paymentDetails.setPayment_type("Net Payment ");
			paymentDetails.setPayment_Status("payment success");
			break;
		case 5:
			paymentDetails.setPayment_type("EMI");
			paymentDetails.setPayment_Status("Under Processing");
			break;
			default :
				System.out.println("invalid ...");
			
		}
		System.out.println("enter the Amount ");
		double paymentAmount=scanner.nextDouble();
		if(paymentAmount==Amount) {
			System.out.println("payment Details ");
			PaymentDAO paymentdao=new PaymentDAO();
//			paymentdao.insertPaymentDetails(paymentDetails);
//			System.out.println(productDetails);
			// instead of printing u can call only payment details ...which contains only the customer id ,product id ,and payment type ,payment status and payment amount ,and also the date 
//			paymentDetails.setAmount(paymentAmount);
			paymentDetails.setCustomer_Id(cid);
			paymentDetails.setProduct_id(pid);
			paymentDetails.setAmount(Amount);
			paymentDetails.setPayment_Date(LocalDate.now());
			paymentDetails.setAmount(paymentAmount);
			if(paymentdao.insertPaymentDetails(paymentDetails)) {
				return true;
			}
			else
			{
				return false;
			}
			
		}
		else
		{
			System.out.println("invalid amount...");
			return false;
		}
	}

}
