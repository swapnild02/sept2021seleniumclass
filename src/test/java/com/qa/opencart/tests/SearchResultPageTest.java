package com.qa.opencart.tests;

public class SearchResultPageTest extends BaseTest {
	
	public void SearchResultPagesetup() {
		accountpage=loginpage.doLogin( prop.getProperty("username"), prop.getProperty("password"));
		accountpage.doSearch(null);
	}

}
