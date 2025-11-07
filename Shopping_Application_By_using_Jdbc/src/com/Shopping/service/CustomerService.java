package com.Shopping.service;

import java.util.List;
import java.util.Scanner;
import com.Shopping.Exception.CustomerDataInvalidException;
import com.Shopping.dao.CustomerDAO;
import com.Shopping.dao.OrderDAO;
import com.Shopping.dto.CartDetails;
import com.Shopping.dto.CustomerDetails;
import com.Shopping.dto.ProductDetails;

public class CustomerService
{
	
	CustomerDAO customerdao=new CustomerDAO();
	ProductService productService=new ProductService();
	PaymentService paymentService=new PaymentService();
	OrderService orderService=new OrderService();
	CartService cartService=new CartService();
	CustomerDetails customerDetails;
	
	Scanner scanner=new Scanner(System.in);
	
	public void customerRegistration() {
		CustomerDetails customerdetails=new CustomerDetails();
		List<CustomerDetails> listofcustomers= customerdao.selectAllCustomerDetails();
				
		System.out.println("Enter the customer name: ");
		String cname=scanner.next();
		System.out.println("Enter the customer Emailid");
		while(true) {
		String cemailid=scanner.next();
		long emailIdCount= listofcustomers.stream().filter((customer) -> customer.getCustomer_Email_id().equals(cemailid)).count();
		try {
			if(!cemailid.contains("@gmail.com")) {
			    throw new CustomerDataInvalidException("Invalid Emailid");		
		}
			if(emailIdCount>0)
			{
				throw new CustomerDataInvalidException("Email Already Existed");
			}
			else
			{
				customerdetails.setCustomer_Email_id(cemailid);
				break;
			}	
		}
		catch(CustomerDataInvalidException e)
		{
			System.out.println(e.getException());
			System.out.println("re-enter the email id ");
			
		}
		}
		System.out.println("Enter Customer Mobile number..");
		while(true) {
		long cmobileNumber=scanner.nextLong();
		long mobilenoCount= listofcustomers.stream().filter((customer) -> customer.getCustomer_MobileNumber()==(cmobileNumber)).count();
		try {
			if(!(cmobileNumber>=6000000000l && cmobileNumber<=9999999999l)) {
			    throw new CustomerDataInvalidException("Invalid MobileNumber ");
		    }
			if(mobilenoCount>0)
			{
				throw new CustomerDataInvalidException("Mobile Number Already Existed");
			}
			else
			{
				customerdetails.setCustomer_MobileNumber(cmobileNumber);
				break;
			}
		
		}
		catch(CustomerDataInvalidException e)
		{
			System.out.println(e.getException());
		}
		}
		System.out.println("Enter the Customer Address");
		String address=scanner.next();
		System.out.println("Enter the customer gender");
		String gender=scanner.next();
		System.out.println("enter the customer password");
		while(true) {
		String password=scanner.next();
		long passwordCount= listofcustomers.stream().filter((customer) -> customer.getCustomer_Password().equals(password)).count();
		if(passwordCount>0)
		{
			throw new CustomerDataInvalidException("password already existed.");
		}
		else
		{
			customerdetails.setCustomer_Password(password);
			break;
		}
		}
		customerdetails.setCustomer_Name(cname);		
		customerdetails.setCustomer_Address(address);
		customerdetails.setCustomer_Gender(gender);
		
		if (customerdao.insertCustomerDetails(customerdetails))
		{
			System.out.println(cname + "registration Successfully");
		} else {
			System.out.println("server 500");
		}
	}
	
	
	public void customerLogin() {
		System.out.println("enter the emailid or mobileno");
		String emailidOrmobileNo=scanner.next();
		System.out.println("enter the password ");
		String password=scanner.next();
	    customerDetails=customerdao.selectCustomerDetailsByusingEmailorMobileNoAndPassword(emailidOrmobileNo, password);
		if(customerDetails!=null)
		{
			System.out.println("Login Successfully..");
			if(customerDetails.getCustomer_Gender().equalsIgnoreCase("Male"))
			{
				System.out.println("hello Mr's : "+customerDetails.getCustomer_Name());
				customerOperations();
			}
			if(customerDetails.getCustomer_Gender().equalsIgnoreCase("Female"))
			{
				System.out.println("hello Miss : "+customerDetails.getCustomer_Name());
				customerOperations();
			}
		}
		else
		{
			System.out.println("invalid (emailid or mobileno)  or password");
		}
		
	}
	public void customerOperations() {
		System.out.println("Enter \n 1.For All Product Details \n 2.For Cart Details  \n 3.For Order Details ");
		int num=scanner.nextInt();
		switch(num) {
		case 1:
			System.out.println(" All product Details ..");
			List<ProductDetails> allProductDetails=productService.selectAllProductDetails();
			int serialno=1;
			for(ProductDetails productDetails:allProductDetails ){
				System.out.println("serial_no : "+serialno++);
				System.out.println("Product Name : "+productDetails.getProduct_Name());
				System.out.println("Product Brand : "+productDetails.getProduct_Brand());
				System.out.println("Product Price : "+productDetails.getProduct_Price());
				System.out.println("Product Category : "+productDetails.getProduct_Category());
				System.out.println("Product MF Date : "+productDetails.getProduct_M_F_Date());
				System.out.println("Product Ex Date : "+productDetails.getProduct_Ex_Date());
				System.out.println("Product Discount : "+productDetails.getProduct_Discount());
				System.out.println("******--------*****--------******--------*******--------");
			}	
			System.out.println("select S.no to add_to_cart or to Buy");
			ProductDetails productDetails=allProductDetails.get(scanner.nextInt()-1);
			System.out.println("Product Name : "+productDetails.getProduct_Name());
			System.out.println("Product Brand : "+productDetails.getProduct_Brand());
			System.out.println("Product Price : "+productDetails.getProduct_Price());
			System.out.println("Product Category : "+productDetails.getProduct_Category());
			System.out.println("Product MF Date : "+productDetails.getProduct_M_F_Date());
			System.out.println("Product Ex Date : "+productDetails.getProduct_Ex_Date());
			System.out.println("Product Discount : "+productDetails.getProduct_Discount());
			System.out.println("******--------*****--------******--------*******--------");
			
			System.out.println("select \n 1.to Add the product to the cart \n 2.to Buy ");
			switch(scanner.nextInt()) {
			case 1:
				System.out.println("Add the product to the cart ");
				System.out.println("enter the product Quantity");
				int quantity=scanner.nextInt();
				CartDetails cartDetails=new CartDetails();
				cartDetails.setCustomer_id(customerDetails.getCustomer_Id());
				cartDetails.setProduct_id(productDetails.getProduct_id());
				cartDetails.setProduct_Quantity(quantity);
				cartService.addCartDetails(cartDetails);
				break;
			case 2:
				System.out.println("to Buy");
				System.out.println("enter the product Quantity");
				int purchasequantity=scanner.nextInt();
				double productprice=productDetails.getProduct_Price();
				double productdiscount=productDetails.getProduct_Discount();
				System.out.println("product_Name : "+productDetails.getProduct_Name());
				System.out.println("product_Brand : "+productDetails.getProduct_Brand());
				System.out.println("product_price : "+productDetails.getProduct_Price());
				System.out.println("product_category : "+productDetails.getProduct_Category());
				double totalcost=purchasequantity*productprice;
				System.out.println("Total Cost : "+totalcost);
				double discountAmount=totalcost*(productdiscount/100);
				System.out.println("Total Discount : "+discountAmount);
				double totalAmount=totalcost-discountAmount;
				System.out.println("total Amount to be paid : "+totalAmount);
				if(paymentService.paymentProcessDetails(customerDetails.getCustomer_Id(), productDetails.getProduct_id(), totalAmount)) {
					System.out.println("Order successful.. ");
					System.out.println("select Address to deliver the product \n 1."+customerDetails.getCustomer_Address()+"\n 2.change Address");
					switch(scanner.nextInt()) {
					case 1:
					orderService.intoOrderDetails(customerDetails.getCustomer_Id(),productDetails.getProduct_id(),customerDetails.getCustomer_Address(), purchasequantity);
					break;
					case 2:
						System.out.println("Enter the Address");
						String address=scanner.next();
						orderService.intoOrderDetails(customerDetails.getCustomer_Id(),productDetails.getProduct_id(),address, purchasequantity);
						break;
					default :
						System.out.println("enter the valid data...");
					break;
					}
				}
				break;
				
				
				default :
					System.out.println("invalid data");
			}
			break;
			
		case 2:
			System.out.println("For cart Details ");
		
		   /* System.out.println("All products available:");
		    List<ProductDetails> allProducts = productService.selectAllProductDetails();
		    if(allProducts == null || allProducts.isEmpty()) {
		        System.out.println("No products available.");
		        break;
		    }

		    int serialNo = 1;
		    for(ProductDetails product : allProducts) {
		        System.out.println("S.No: " + serialNo++);
		        System.out.println("Product ID: " + product.getProduct_id());
		        System.out.println("Name: " + product.getProduct_Name());
		        System.out.println("Brand: " + product.getProduct_Brand());
		        System.out.println("Price: " + product.getProduct_Price());
		        System.out.println("Category: " + product.getProduct_Category());
		        System.out.println("Quantity Available: " + product.getProduct_Quantity());
		        System.out.println("Discount: " + product.getProduct_Discount() + "%");
		        System.out.println("-------------------------------");
		    }

		    System.out.println("Select product S.No to add to cart:");
		    int selectedIndex = scanner.nextInt() - 1;
		    if(selectedIndex < 0 || selectedIndex >= allProducts.size()) {
		        System.out.println("Invalid selection.");
		        break;
		    }

		    ProductDetails selectedProduct = allProducts.get(selectedIndex);

		    System.out.println("Enter quantity to add to cart:");
		    int quantity = scanner.nextInt();
		    if(quantity <= 0 || quantity > selectedProduct.getProduct_Quantity()) {
		        System.out.println("Invalid quantity.");
		        break;
		    }

		    CartDetails cartDetails = new CartDetails();
		    cartDetails.setCustomer_id(customerDetails.getCustomer_Id());
		    cartDetails.setProduct_id(selectedProduct.getProduct_id());
		    cartDetails.setProduct_Quantity(quantity);

		    cartService.addCartDetails(cartDetails); // saves cart*/
		  

			
			break;
		case 3:
			System.out.println("For Order Details ");
			break;
		default:
				System.out.println("invalid ....");
		}
		
	}
}
