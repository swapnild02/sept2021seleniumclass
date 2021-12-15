package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utility.ElementsUlility;

public class ProductInfoPage {

	private ElementsUlility eu;
	
	Map<String,String> product;

	public ProductInfoPage(WebDriver driver) {

		eu = new ElementsUlility(driver);
	}

	By addtocartbtn = By.id("button-cart");

	public boolean isAddToCartbtnDisplayed() {
		return eu.isDisplayed(addtocartbtn);
	}

	public void clickAddToCartbtn() {
		eu.doclick(addtocartbtn);
	}

	By productheader = By.xpath("(//h1)[last()]");

	public String getProductHeader() {
		String header = eu.getTextFromSpecificElement(productheader, 5);
		System.out.println("My product Header ***> " + header);
		return header;
	}

	// ((//div[@class='col-sm-4'])[2]//ul)[1]/li
	By productmetadata = By.cssSelector("div.col-sm-4:nth-of-type(2) ul:nth-of-type(1) li");
	By productpricedata = By.cssSelector("div.col-sm-4:nth-of-type(2) ul:nth-of-type(2) li");

	public Map<String,String> getProductInfo() {
		product=new LinkedHashMap<String,String>();
		 product.put("Product Name", getProductHeader());
		 getProductMetaData();
		 getProductPriceData();
		 return product;
	}
	
	private void getProductMetaData() {
		List<String> productmetadatatext = eu.getTextFromList(productmetadata);
		for (String s : productmetadatatext) {
			String[] text=s.split(":");
			String key=text[0].trim();
			String value=text[1].trim();
			 product.put(key, value);
		}
	}
	
	private void getProductPriceData() {
		List<String> productpricetext = eu.getTextFromList(productpricedata);
		String price=productpricetext.get(0).trim();
		String exprice=productpricetext.get(1).trim();
		product.put("Original Price", price);
		product.put("Ex Price", exprice);
	}

	By qty_textbox = By.id("input-quantity");

	public void qty_textbox(String value) {
		eu.doSendKeys(qty_textbox, value);
	}

}
