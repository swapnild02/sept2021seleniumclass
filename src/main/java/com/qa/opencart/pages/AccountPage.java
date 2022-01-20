package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.opencart.utility.ConstantsOpenCart;
import com.qa.opencart.utility.ElementsUlility;

public class AccountPage {
	 private WebDriver driver;
	 private ElementsUlility eu;
	 LoginPage lp;
	
	 public AccountPage(WebDriver driver) {
		this.driver=driver;
		eu=new ElementsUlility(driver);
	}
	
	private By yourStore_linkText = By.linkText("Your Store");
	private By accountSection_cssSelector = By.cssSelector("div#content h2");
	private By searchtxtbox= By.name("search");
	private By searchbtn= By.className("btn-default");
	private By logoutbtn_linkText=By.linkText("Logout");
	
	
	public String getAccountPageTitle() {
		return eu.getTitle(ConstantsOpenCart.ACCOUNT_PAGE_TITLE, ConstantsOpenCart.DEFAULT_TIME_OUT);
	}
	
	public boolean isLogOutLinkExist() {
		return eu.isDisplayed(logoutbtn_linkText);
		
	}
	
	public LogoutPage logout() {
		if(isLogOutLinkExist())
			eu.doclick(logoutbtn_linkText);
		return new LogoutPage(driver);
	}
	
	public List<String> getAccountSecList() {
		List<WebElement> accountsectionlist=eu.findElements(accountSection_cssSelector, ConstantsOpenCart.DEFAULT_TIME_OUT);
		List<String > accountsectionlisttext=new ArrayList<String>();
		for(WebElement s:accountsectionlist) {
			accountsectionlisttext.add(s.getText());
		}
		return accountsectionlisttext;
	}
	
	public void isSearchTextBoxExist() {
		eu.isDisplayed(searchtxtbox);
	}
	
	public SearchResultPage doSearch(String productname) {
		System.out.println("Product Searched --> "+productname);
		eu.doSendKeys(searchtxtbox, productname);
		eu.doclick(searchbtn);
		return new SearchResultPage(driver);
	}
	
	public String getAccountPageHeader() {
		return eu.getTextFromSpecificElement(yourStore_linkText);
	}
	
	
	
	

}
