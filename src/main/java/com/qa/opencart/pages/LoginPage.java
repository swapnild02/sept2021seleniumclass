package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.opencart.utility.ConstantsOpenCart;
import com.qa.opencart.utility.ElementsUlility;

public class LoginPage {
	private WebDriver driver;
	private ElementsUlility eu;
	private HomePage homepage;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eu=new ElementsUlility(driver);
		homepage=new HomePage(driver);
		
	}
	
	private By username_id=By.id("input-email");
	private By password_id=By.id("input-password");
	private By clickonloginbtn_xpath=By.xpath("//input[@value='Login']");
	private By registerlink_linktext=By.linkText("Register");
	
	public AccountPage doLogin( String usename,String password) {
//		homepage.clickOnSpecificFotterWebElement(Constants.MY_ACCOUNT_LINK,10);
		eu.doSendKeys(username_id, usename);
		eu.doSendKeys(password_id, password);
		eu.doclick(clickonloginbtn_xpath);
		return new AccountPage(driver);
		
	}
	By loginwithwrongcrenditalsmsg=By.xpath("//div[@class='alert alert-danger alert-dismissible' and text()=' Warning: No match for E-Mail Address and/or Password.']");
	
	public boolean doLoginWithWrongCrenditals( String usename,String password) {
		homepage.clickOnSpecificFotterWebElement(ConstantsOpenCart.MY_ACCOUNT_LINK,10);
		eu.doSendKeys(username_id, usename);
		eu.doSendKeys(password_id, password);
		eu.doclick(clickonloginbtn_xpath);
		String wrongcrenditalmsg=eu.getTextFromSpecificElement(loginwithwrongcrenditalsmsg);
		System.out.println("Woring msg text is --------> "+wrongcrenditalmsg);
		if(wrongcrenditalmsg.equals(ConstantsOpenCart.LOGIN_WRONG_CRENDITAL_MESSAGE)) {
			System.out.println("Unable to login with "+usename+" and "+password);
			return false;
		}
		System.out.println("Able to login with "+usename+" and "+password);
		return true;
	}
	
	public String titleLoginPage() {
		return eu.getTitle(ConstantsOpenCart.LOGIN_PAGE_TITLE, ConstantsOpenCart.DEFAULT_TIME_OUT);
	}
	
	public String getLoginPageCurrentUrl() {
		return eu.getCurrenturl(ConstantsOpenCart.LOGIN_PAGE_CURRENT_URL_FRACTION, ConstantsOpenCart.DEFAULT_TIME_OUT);
	}
	
	public RegisterPage clickOnRegisterLinks() {
		// homepage.clickOnSpecificFotterWebElement(Constants.MY_ACCOUNT_LINK, 10);
		eu.doclick(registerlink_linktext);
		return new RegisterPage(driver);
	}
	
	public boolean isRegisterLinkPresent() {
		// homepage.clickOnSpecificFotterWebElement(Constants.MY_ACCOUNT_LINK, 10);
		return eu.isDisplayed(registerlink_linktext);
	}

}
