package com.qa.opencart.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {
	WebDriver driver;
	
	public JavaScriptUtility(WebDriver driver) {
		this.driver=driver;
	}
	
	public void highlightwebelement(WebElement element) {
		String bgcolor=element.getCssValue("backgroundColor");
		for(int i=0;i<10;i++) {
			changeColor("rgb(0,200,0)",element);
			changeColor(bgcolor,element);
		}
	}
	
	public void changeColor(String color,WebElement element) {
		
		JavascriptExecutor js= ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor= '"+color+"'     ", element);
		try {
			Thread.sleep(20);
		}catch(InterruptedException e) {
			
		}
		
	}

}
