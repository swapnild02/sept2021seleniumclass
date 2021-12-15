package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utility.ElementsUlility;

public class LogoutPage {
	
	WebDriver driver;
	ElementsUlility eu;
	
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		eu=new ElementsUlility(driver);
	}
	
	By Account_Logout=By.xpath("(//h1)[2]");
	By continue_btn=By.linkText("Continue");
	
	public String getText_Account_Logout() {
		return eu.getTextFromSpecificElement(Account_Logout);
	}
	
	public HomePage clickOnContinuebtn() {
		eu.doclick(continue_btn);
		return new HomePage(driver);
	}
	

}
