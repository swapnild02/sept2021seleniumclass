package com.qa.opencart.utility;
//package com.qa.opencart.utility;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.opencart.factory.DriverFractory;

public class ElementsUlility {
	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtility jsu;
	public WebElement element;

	
	public ElementsUlility(WebDriver driver) {
		this.driver=driver;
		jsu=new JavaScriptUtility(driver);
	}
	
	
	
	/************** find the web element/elements******/ 
	
	public WebElement findElement(By locator) {
		 element=driver.findElement(locator);
		if(Boolean.parseBoolean(DriverFractory.highlight)) {
			jsu.highlightwebelement(element);
		}
//		getSpecificWebElementScreenshoot();
		return element;
	}
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}
	
	public List<WebElement> findElements(By locator, long timeOut) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	/************** Do actions on web element/elements with also wait******/ 
	
	public void doSendKeys(By locator,String value) {
		findElement(locator).clear();
		findElement(locator).sendKeys(value);
	}
	
	public void doclick(By locator) {
		findElement(locator).click();
	}
	
	
	public boolean isDisplayed(By locator) {
		return findElement(locator).isDisplayed();
	}
	
	public void isEnabled(By locator) {
		findElement(locator).isEnabled();
	}
	
	public void isSelected(By locator) {
		findElement(locator).isSelected();
	}
	
	// ***************get Test/Texts from WebElement*************
	
	public String getTextFromSpecificElement(By locator) {
		return findElement(locator).getText();
	}
	public String getTextFromSpecificElement(By locator, long timeout) {
		element=waitForvisibilityOfElementLocated(locator,timeout);
		return element.getText();
	}
	
	public List<String> getTextFromList(By locator) {
		List<String> listtext=new ArrayList<String>();
		List<WebElement> element=findElements(locator);
		for(WebElement e:element) 
		{
			listtext.add(e.getText());
		}
		return listtext;
	}
	
	
	public void doclick(By locator,int timeOut) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		 element= wait.until(ExpectedConditions.elementToBeClickable(locator));
		 element.click();
	}
	
	public String getTitle() {
		return driver.getTitle();	
	}
	
	public String getTitle(String title,long timeout) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		boolean flag=wait.until(ExpectedConditions.titleIs(title));
		if(flag==true) {
			return getTitle();
		}
		else {
			return null;
		}
	}
	
	public String getTitle(String title,long timeout,long miliseconds) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(miliseconds));
		boolean flag=wait.until(ExpectedConditions.titleIs(title));
		if(flag==true) {
			return getTitle();
		}
		else {
			return null;
		}
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getCurrenturl(String urlfraction,int timeOut) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		boolean flag=wait.until(ExpectedConditions.urlContains(urlfraction));
		if(flag==true) {
			return getCurrentUrl();
		}
		return null;
	}
	
	public String getCurrenturl(String fullurl,long timeOut) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		boolean flag=wait.until(ExpectedConditions.urlToBe(fullurl));
		if(flag==true) {
			return getCurrentUrl();
		}
		return null;
	}
	
	public String getCurrenturl(String fullurl,long timeOut,long miliseconds) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut),Duration.ofMillis(miliseconds));
		boolean flag=wait.until(ExpectedConditions.urlToBe(fullurl));
		if(flag==true) {
			return getCurrentUrl();
		}
		return null;
	}
	
	public List<WebElement> waitForElementvisibilityOfAllElementsLocatedBy(By locator, long timeout) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	private WebElement waitForvisibilityOfElementLocated(By locator, long timeout) 
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public File getSpecificWebElementScreenshoot() {
		File source=element.getScreenshotAs(OutputType.FILE);
		return source;
	}
	
//public String getSpecificWebElementScreenshoot() {
//		
//		File source=element.getScreenshotAs(OutputType.FILE);
//		String path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
//		File DestFile=new File(path);
//		try {
//			FileUtils.copyFile(source, DestFile);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return path;
//	}



}
