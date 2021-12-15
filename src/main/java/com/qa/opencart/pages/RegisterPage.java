package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.opencart.utility.ElementsUlility;

public class RegisterPage {
	
	private WebDriver driver;
	private ElementsUlility eu;

	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		eu=new ElementsUlility(driver);

	}
	By firstname=By.id("input-firstname");
	By lastname=By.id("input-lastname");
	By e_mail=By.id("input-email");
	By telephone=By.id("input-telephone");
	By password=By.id("input-password");
	By confirmpassword=By.id("input-confirm");
	
	By  privacy_policy=By.xpath("(//div[@class='pull-right']//input)[1]");
//	(//div[@class='pull-right']//input)[2]
	By registerbth=By.className("btn-primary"); 
	By subscribeyes=By.xpath("(//div[@class='col-sm-10']//input[@type='radio'])[2]");
	By subscribeno=By.xpath("(//div[@class='col-sm-10']//input[@type='radio'])[3]");
	
	By errormsg=By.xpath("//div[@class='alert alert-danger alert-dismissible']");
	
	public RegisterSuccessPage fillPersonalDetails(String fName,String lName,
															   String email,String telephone,
															   String password,String subscribe) {
		eu.doSendKeys(firstname, fName);
		eu.doSendKeys(lastname, lName);
		eu.doSendKeys(e_mail, email);
		eu.doSendKeys(this.telephone, telephone);
		eu.doSendKeys(this.password, password);
		eu.doSendKeys(confirmpassword, password);
		if(subscribe.equals("yes")) {
			eu.doclick(subscribeyes);
		}
			else {
				eu.doclick(subscribeno);
			}
		
		eu.doclick(privacy_policy);
		eu.doclick(registerbth);
		return new RegisterSuccessPage(driver);
		}

public String getErrormsgWhileNotRegisterSuccesfull() {
	String test=eu.getTextFromSpecificElement(errormsg);
	System.out.println("Error message is  "+test);
	
	return test;
}
}
