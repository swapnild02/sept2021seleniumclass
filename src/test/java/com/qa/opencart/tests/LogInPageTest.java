package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.opencart.listerner.TestAllureListener;
import com.qa.opencart.utility.ConstantsOpenCart;
@Listeners(TestAllureListener.class)
public class LogInPageTest extends BaseTest {
	
	@BeforeClass
	public void setupLogInPageTest() {
		System.out.println("******************setupLogInPageTest() started");
		loginpage=homepage.clickOnSpecificFotterWebElement(ConstantsOpenCart.MY_ACCOUNT_LINK, ConstantsOpenCart.DEFAULT_TIME_OUT);
		System.out.println("***********setupLogInPageTest() ended");
	}

	@Test(priority = 4)
	public void VerifyLoginTest() {
		accountpage = loginpage.doLogin( prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accountpage.getAccountPageTitle(), ConstantsOpenCart.ACCOUNT_PAGE_TITLE);
	}

	@Test(priority = 1)
	public void verifyLoginTitleTest() {
		String actualTitle = loginpage.titleLoginPage();
		Assert.assertEquals(actualTitle, ConstantsOpenCart.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void verifyLoginCurrentUrlTest() {
		String actualTitle = loginpage.getLoginPageCurrentUrl();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, ConstantsOpenCart.LOGIN_PAGE_CURRENT_URL_FRACTION);
	}
	
	@Test(priority = 3)
	public void verifyRegistrationLinkPresentOrNotTest() {
		System.out.println("******************8verifyRegistrationLinkPresentOrNotTest()  started");
		boolean flag= loginpage.isRegisterLinkPresent();
		System.out.println("************888verifyRegistrationLinkPresentOrNotTest()  ended");
		
		System.out.println("*************Assert  started");
		Assert.assertTrue(flag);
		System.out.println("*************Assert  ended");
	}

}
