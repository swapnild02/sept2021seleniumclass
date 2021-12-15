package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFractory;
import com.qa.opencart.factory.OptionManager;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.LogoutPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.RegisterSuccessPage;
import com.qa.opencart.pages.SearchResultPage;

public class BaseTest {
	DriverFractory df=new DriverFractory();
	Properties prop;
	WebDriver driver;
	HomePage homepage;
	LoginPage loginpage;
	AccountPage accountpage;
	SearchResultPage  searchresultpage;
	ProductInfoPage productinfopage;
	SoftAssert softassert;
	OptionManager op;
	RegisterPage registerpage;
	RegisterSuccessPage registersuccesspage;
	LogoutPage logout;
	
	
	@BeforeTest
	public void setup() {
		System.out.println("*********************8start");
		prop=df.init_properties();
		System.out.println("*****************init_properties() created");
		driver=df.init_Driver(prop.getProperty("browserName"));
		System.out.println("*****************init_Driver(prop.getProperty(\"browserName\")) created");
		homepage=new HomePage(driver);
		System.out.println("**************8HomePage(driver) object created");
		op=new OptionManager(prop);
		System.out.println("******************OptionManager(prop) object created");
//		String browserName=op.getchromeOptions().getBrowserName();
//		System.out.println("Browser Name is $$$$ "+browserName);
//		String browserversion=op.getchromeOptions().getBrowserVersion();
//		System.out.println("Browser version is %%%%%  "+browserversion);
		
		softassert=new SoftAssert();
		System.out.println("***************************SoftAssert() object created");
	}
	
   @AfterTest
	public void teardown() {
		df.quitDriver();
	}

}
