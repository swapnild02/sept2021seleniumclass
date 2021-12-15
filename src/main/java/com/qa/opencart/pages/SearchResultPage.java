package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utility.ElementsUlility;

public class SearchResultPage {
	private WebDriver driver;
	private ElementsUlility eu;
	
	
	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		eu=new ElementsUlility(driver);
	}

	private By productresult=By.xpath("//div[@class='caption']//a");
	
	public int totalNumberOfProduct() {
		return eu.waitForElementvisibilityOfAllElementsLocatedBy(productresult, 10).size();
	}
	
	public ProductInfoPage searchProduct(String productname) {
		List<WebElement> ele=eu.waitForElementvisibilityOfAllElementsLocatedBy(productresult, 10);
		for(WebElement e:ele) {
			String producttext=e.getText();
			if(producttext.equals(productname)) {
				System.out.println("Main Product click --> "+producttext);
				e.click();
				break;
			}
		}
		
		return new ProductInfoPage(driver);
		
	}
	
	By Productsmeetingthesearchcriteria=By.tagName("h2");
	
	public String getTextProductsmeetingthesearchcriteria() {
		String text= eu.getTextFromSpecificElement(Productsmeetingthesearchcriteria,10);
	   System.out.println("Productsmeetingthesearchcriteria --> "+text);
		return text;
	}
	
}
