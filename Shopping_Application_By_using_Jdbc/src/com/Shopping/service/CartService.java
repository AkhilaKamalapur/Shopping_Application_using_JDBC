package com.Shopping.service;

import com.Shopping.dao.CartDAO;
import com.Shopping.dto.CartDetails;

public class CartService
{
	
	CartDAO cartdao=new CartDAO();
	public void addCartDetails(CartDetails cartDetails)
	{
		if (cartdao.insertCartDetails(cartDetails)) {
			System.out.println("Product Added to the Cart");
		} else {
			System.out.println("server error 500 ");

		}
	}
}
