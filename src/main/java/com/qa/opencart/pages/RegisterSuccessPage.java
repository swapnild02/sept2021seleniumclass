package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utility.ElementsUlility;

public class RegisterSuccessPage {
	
	private WebDriver driver;
	private ElementsUlility eu;
	
	public RegisterSuccessPage(WebDriver driver) {
		this.driver=driver;
		eu=new ElementsUlility(driver);
	}
	
	By Your_Account_Has_Been_Created_Text=By.xpath("(//h1)[2]");
	By continue_btn=By.linkText("Continue");
	
	public String getText_Your_Account_Has_Been_Created() {
		return eu.getTextFromSpecificElement(Your_Account_Has_Been_Created_Text);
	}
	
	public AccountPage clickOnContinuebtn() {
		eu.doclick(continue_btn);
		return new AccountPage(driver);
	}
	

}
