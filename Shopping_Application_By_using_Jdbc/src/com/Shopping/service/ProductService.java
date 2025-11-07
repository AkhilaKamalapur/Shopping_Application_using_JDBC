package com.Shopping.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Shopping.dao.ProductDAO;
import com.Shopping.dto.ProductDetails;

public class ProductService {

	ProductDAO productdao=new ProductDAO();
	Scanner scanner=new Scanner(System.in);
	
//	private String productname;
//	private String productbrand;
//	private double productprice;
//	private String productMfdate;
//	private String productExdate;
//	private int productQuantity;
//	private String productCategory;
//	private double productDiscount;
	
	public void storeProductDetails() {
		System.out.println("Enter the product name");
		String pname=scanner.next();
		System.out.println("enter the product brand");
		String pbrand=scanner.next();
		System.out.println("enter the product price");
		double pprice=scanner.nextDouble();
		System.out.println("enter the product Mfdate");
		String pMfdate=scanner.next();
		System.out.println("enter the product Exdate");
		String pExdate=scanner.next();
		System.out.println("enter the product quantity");
		int pquantity=scanner.nextInt();
		System.out.println("enter the product category");
		String pcategory=scanner.next();
		System.out.println("enter the product discount");
		double pdiscount=scanner.nextDouble(); 
		ProductDetails productDetails=new ProductDetails();
		
		productDetails.setProduct_Name(pname);
		productDetails.setProduct_Brand(pbrand);
		productDetails.setProduct_Price(pprice);
		productDetails.setProduct_M_F_Date(Date.valueOf(pMfdate));
		productDetails.setProduct_Ex_Date(Date.valueOf(pExdate));
		productDetails.setProduct_Quantity(pquantity);
		productDetails.setProduct_Category(pcategory);
		productDetails.setProduct_Discount(pdiscount);
		productdao.insertProductDetails(productDetails);
		
	}

	public void storeProductsByUsingBrand() {
		
		List<ProductDetails> list=new ArrayList<ProductDetails>();
		System.out.println("Enter Product Brand");
		String pbrand=scanner.next();
		System.out.println("Number of products Under "+pbrand+"Brand");
		int number=scanner.nextInt();
		String nu[]= {"First ","second","third","Fouth","Fifth"};
		
		for(int i=0;i<number;i++) {
			System.out.println("Enter "+nu[i]+"product Details");
		
		
		System.out.println("Enter the product name");
		String pname=scanner.next();
		
		System.out.println("enter the product price");
		double pprice=scanner.nextDouble();
		System.out.println("enter the product Mfdate");
		String pMfdate=scanner.next();
		System.out.println("enter the product Exdate");
		String pExdate=scanner.next();
		System.out.println("enter the product quantity");
		int pquantity=scanner.nextInt();
		System.out.println("enter the product category");
		String pcategory=scanner.next();
		System.out.println("enter the product discount");
		double pdiscount=scanner.nextDouble(); 
		ProductDetails productDetails=new ProductDetails();
		
		productDetails.setProduct_Name(pname);
		productDetails.setProduct_Brand(pbrand);
		productDetails.setProduct_Price(pprice);
		productDetails.setProduct_M_F_Date(Date.valueOf(pMfdate));
		productDetails.setProduct_Ex_Date(Date.valueOf(pExdate));
		productDetails.setProduct_Quantity(pquantity);
		productDetails.setProduct_Category(pcategory);
		productDetails.setProduct_Discount(pdiscount);
		productdao.insertProductDetails(productDetails);
		list.add(productDetails);
		}
		if (productdao.insertMorethanOneProduct(list)) {
			System.out.println("product inserted successfully.");
			
		} else {
			System.out.println("server error 500");

		}
	}
	
	public List<ProductDetails> selectAllProductDetails() {
		List<ProductDetails> list=productdao.getAllProductDetails();
		if(list!=null)
		{
			System.out.println("Product Details");
			System.out.println("list");
		}
		else
		{
			System.out.println("Server 500");
		}
		return list;
	}
	
}





	
		
		
		
		
		
		
	     













