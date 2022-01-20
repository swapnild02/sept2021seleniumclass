package com.qa.opencart.utility;

import java.util.ArrayList;
import java.util.List;

public class ConstantsOpenCart {
	
	public static final String HOME_PAGE_YOURSTORE_LINK="Your Store";
	public static final String HOME_PAGE_Featured = "Featured";
	public static final String HOME_PAGE_Powered_By = "Powered By";
	public static final String HOME_PAGE_OpenCart = "OpenCart";
	public static final String HOME_PAGE_TITLE = "Your Store";
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final long DEFAULT_TIME_OUT=5;
	public static final String LOGIN_PAGE_CURRENT_URL_FRACTION= "https://demo.opencart.com/index.php?route=account/login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_PAGE_HEADERLINK = "Your Store";
	public static final String PRODUCTINFO_PAGE_HEADERLINK = "Products meeting the search criteria";
	public static final String MY_ACCOUNT_LINK = "My Account";
	public static final String LOGIN_WRONG_CRENDITAL_MESSAGE = "Warning: No match for E-Mail Address and/or Password.";
	public static final String REGISTER_SUCCESS_PAGE_TEXT = "Your Account Has Been Created!";
	
	
	
	public static final List<String> accountsecList() {
		List<String> acclist=new ArrayList<String>();
		acclist.add("My Account");
		acclist.add("My Orders");
		acclist.add("My Affiliate Account");
		acclist.add("Newsletter");
		
		return acclist;
	}
	
	public static final  List<String> menuItemTextList() {
		List<String> menulist=new ArrayList<String>();
		menulist.add("Desktops");
		menulist.add("Laptops & Notebooks");
		menulist.add("Components");
		menulist.add("Tablets");
		menulist.add("Software");
		menulist.add("Phones & PDAs");
		menulist.add("Cameras");
		menulist.add("MP3 Players");
		
		return menulist;
	}
	
	public static final  List<String> fotterItemTextList() {
		List<String> fotterItemList=new ArrayList<String>();
		fotterItemList.add("About Us");
		fotterItemList.add("Delivery Information");
		fotterItemList.add("Privacy Policy");
		fotterItemList.add("Terms & Conditions");
		fotterItemList.add("Contact Us");
		fotterItemList.add("Returns");
		fotterItemList.add("Site Map");
		fotterItemList.add("Brands");
		fotterItemList.add("Gift Certificates");
		fotterItemList.add("Affiliate");
		fotterItemList.add("Specials");
		fotterItemList.add("My Account");
		fotterItemList.add("Order History");
		fotterItemList.add("Wish List");
		fotterItemList.add("Newsletter");
		
		return fotterItemList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	

}
