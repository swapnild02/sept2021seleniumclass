package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class LoginPageNegativeTest extends BaseTest {
	
	@DataProvider
	public Object[][] sendWrongCrendital() {
		return new Object[][]
		                    {
		                    		{"testing@gmail.com","123"},
		                    		{"swapnild02@gmail.com",""},
		                    		{"","123456"},
		                    		{"",""},
		                    		{" ","123456"},
		                    		{"swapnild02@gmail.com"," "}
		                    };
			
		}
	
	@Test(dataProvider="sendWrongCrendital")
	public void loginNegativeTest(String username,String password) {
       boolean actualflag=loginpage.doLoginWithWrongCrenditals(username,password);
       Assert.assertFalse(actualflag);
	
	
	}

}
