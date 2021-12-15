package com.qa.opencart.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.listerner.TestAllureListener;
import com.qa.opencart.utility.Constants;
import com.qa.opencart.utility.PagesName;

import io.qameta.allure.Description;
@Listeners(TestAllureListener.class)
public class HomePageTest extends BaseTest {

@Description("Verify your Strore link is present or not on "+PagesName.HOME_PAGE_NAME)
	@Test(priority = 2)
	public void verifyyourStorelink() {
		String actualResult = homepage.yourStorelink();
		System.out.println("Actual Result is " + actualResult);
		Assert.assertEquals(actualResult, Constants.HOME_PAGE_YOURSTORE_LINK.trim());
	}

	@Test(priority = 1)
	public void verifyFeatureTex() {
		String actualResult = homepage.featuredText();
		System.out.println("Actual Result is " + actualResult);
		Assert.assertEquals(actualResult, Constants.HOME_PAGE_Featured.trim());
	}

	@Test(priority = 3)
	public void verifyOpenCartLinkPresent() {
		String actualResult = homepage.openCartLink();
		System.out.println("Actual Result is " + actualResult);
		Assert.assertEquals(actualResult, Constants.HOME_PAGE_OpenCart.trim());
	}

	@Test(priority = 4)
	public void verifyPowered_ByTex() {
		String actualResult = homepage.powered_By_Text();
		System.out.println("Actual Result is " + actualResult);
		Assert.assertEquals(actualResult, Constants.HOME_PAGE_Powered_By.trim());
	}

	@Test(priority = 6)
	public void verifyMenuitems() {
		List<String> actualmenuitemdata = homepage.getmenuitemsTexts();
		Assert.assertEquals(actualmenuitemdata, Constants.menuItemTextList());
	}

	// @DataProvider
	// public Object[][] menuItemTextList()
	// {
	// Object[][] mat =
	// {
	// {"Desktops"},
	// {"Laptops & Notebooks"},
	// {"Components"},
	// {"Tablets"},
	// {"Software"},
	// {"Phones & PDAs"},
	// {"Cameras"},
	// {"MP3 Players"}
	// };
	// return mat;
	// }

	// @Test(dataProvider= "menuItemTextList")
	// public void verifyMenuitems(String menuItemText )
	// {
	// boolean flag =false;
	//
	// List<String> menuitemdata=hp.getmenuitemsTexts();
	// for( String s:menuitemdata)
	// {
	// System.out.println("S Actual---> "+s);
	// System.out.println("menuItemText Expected---> "+menuItemText);
	// if(s.equals(menuItemText))
	// {
	// flag=true;
	// break;
	// }
	//
	// }
	// if(flag==true)
	// {
	// Assert.assertTrue(flag);
	// }
	// else
	// {
	//
	// Assert.assertTrue(flag);
	// }
	// }

	@Test(priority = 7)
	public void verifyseachTextBox() {
		boolean b = homepage.SearchTextBox();
		Assert.assertTrue(b);
	}

	@Test(priority = 8)
	public void verifyseachbtn() {
		boolean b = homepage.Searchbtn();
		Assert.assertTrue(b);
	}

	@Test(priority = 9)
	public void verifyItemcartbtn() {
		boolean b = homepage.itembtn();
		Assert.assertTrue(b);
	}

	@Test(priority = 10)
	public void verifyfotterpresent() {
		List<String> actualfotterText = homepage.getTextOfFotter();
		Assert.assertEquals(actualfotterText, Constants.fotterItemTextList());

		// for(String s:actualfotterText) {
		// System.out.println(s);
		// }

	}

	// @Test()
	// public void verifyfotterpresent()
	// {
	// boolean flag=false;
	// String s1=null;
	// List<String> fText=hp.getTextOfFotter();
	// for( String s:fText)
	// {
	// s1=s;
	// System.out.println(s);
	// if(s1.equals("Contact Us"))
	// {
	// flag=true;
	// break;
	// }
	// }
	//
	// if(flag==true)
	// {
	// Assert.assertTrue(flag);
	// }
	// else
	// {
	// Assert.assertTrue(flag);
	// }
	// }
	@Test(priority = 12)
	public void clickOnMyAccountLink() {
		loginpage = homepage.clickOnSpecificFotterWebElement("My Account",10);
		String loginPageTitle = loginpage.titleLoginPage();
		System.out.println("loginPageTitle --> " + loginPageTitle);
		
//		Assert.assertEquals(loginPageTitle, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 11)
	public void clickOnSpecificFotterWebElementVis() {
		boolean b = homepage.isSpecificFotterWebElementVisible("My Account");
		System.out.println(b);
	}

}
