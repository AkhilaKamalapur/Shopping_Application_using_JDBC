package com.Shopping.dto;

public class Admin 
{
	
	private int Admin_id;
	private String Admin_Email_id;
	private String Admin_Password;
	private String Admin_Role;
	
	public String getAdmin_Email_id() {
		return Admin_Email_id;
	}

	public void setAdmin_Email_id(String admin_Email_id) {
		Admin_Email_id = admin_Email_id;
	}

	public String getAdmin_Password() {
		return Admin_Password;
	}

	public void setAdmin_Password(String admin_Password) {
		Admin_Password = admin_Password;
	}

	public String getAdmin_Role() {
		return Admin_Role;
	}

	public void setAdmin_Role(String admin_Role) {
		Admin_Role = admin_Role;
	}

	public int getAdmin_id() {
		return Admin_id;
	}

	public Admin(int admin_id, String admin_Email_id, String admin_Password, String admin_Role) {
		
		Admin_id = admin_id;
		Admin_Email_id = admin_Email_id;
		Admin_Password = admin_Password;
		Admin_Role = admin_Role;
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	
	

}
