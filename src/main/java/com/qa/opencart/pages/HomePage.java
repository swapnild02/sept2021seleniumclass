package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utility.ElementsUlility;

import io.qameta.allure.Step;

public class HomePage {
	private WebDriver driver;
	private ElementsUlility eu;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		eu= new ElementsUlility(driver);
	}
	
	private String footerBeforeS="(//div[@class='row'])[last()]//li/a[text()='";
	private String footerAeforeS="']";
	private By yourStore=By.linkText("Your Store");
	private By Featured=By.xpath("//h3[text()='Featured']");
	private By Powered_By=By.xpath("(//div[@class='container'])[5]/p");
	private By OpenCaart_link=By.linkText("OpenCart");
//	private By OpenCaart_link=By.xpath("//p[contains(text(),'Powered By')]/a");
	
	private By Menuitems=By.xpath("//div[@class='collapse navbar-collapse navbar-ex1-collapse']/ul/li");
	private By searchtxtbox= By.name("search");
	private By searchbtn= By.className("btn-default");
	private By itembtn= By.xpath("//div[@id='cart']/button");
	private By getfottertext=By.xpath("(//div[@class='row'])[last()]//ul//a");
	private By fotterlinks=By.xpath("(//div[@class='row'])[4]//li/a");	
	
	
	@Step("Method for yourStorel ink and return text")
	public String yourStorelink() {
		String text= eu.getTextFromSpecificElement(yourStore);
		return text;
	}
	
	public String powered_By_Text() {
		String text1= eu.getTextFromSpecificElement(Powered_By);
		String text=text1.substring(0, 10);
		return text;
	}
	public String Your_Store_2021_Text() {
		String text1= eu.getTextFromSpecificElement(Powered_By);
		String text=text1.substring(19, 37);
		return text;
	}
	public String openCartLink() {
		String text= eu.getTextFromSpecificElement(OpenCaart_link);
		return text;
	}
	
	public String featuredText() 
	{
		String text= eu.getTextFromSpecificElement(Featured);
		return text;
	}
	public List<String> getmenuitemsTexts() 
	{
		return eu.getTextFromList(Menuitems);
	}
	
	public boolean SearchTextBox() 
	{
		return eu.isDisplayed(searchtxtbox);
	}
	public void verifyTextEnterInSearchTextBox(String value) 
	{
	}
	public boolean Searchbtn() 
	{
		return eu.isDisplayed(searchbtn);
	
	}
	public boolean itembtn() {
		return eu.isDisplayed(itembtn);
	
	}
	public List<String> getTextOfFotter() 
	{
		return eu.getTextFromList(getfottertext);
	}
	
//	public LoginPage clickOnSpecificFotterWebElement(String fotterWebElement) 
//	{
//		By clickOnSpecificFotterWebElements=By.xpath(footerBeforeS+fotterWebElement+footerAeforeS);
//		eu.doclick(clickOnSpecificFotterWebElements,500);
//		return new LoginPage(driver);
//		
//	}
	@Step("Clic on {0} link")
	public LoginPage clickOnSpecificFotterWebElement(String fotterWebElement,long timeout) 
	{
		try {
		List<WebElement> ele=eu.findElements(fotterlinks,timeout);
		for(WebElement e:ele) {
			String text=e.getText();
			if(text.equals(fotterWebElement)) {
				e.click();
				break;
			}
			
		}
		
		}catch(StaleElementReferenceException e) {
			e.printStackTrace();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new LoginPage(driver);
	}
	
	public boolean isSpecificFotterWebElementVisible(String fotterWebElement) 
	{
		By clickOnSpecificFotterWebElements=By.xpath(footerBeforeS+fotterWebElement+footerAeforeS);
		return eu.isDisplayed(clickOnSpecificFotterWebElements);
		
	}
	

	


}
