package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utility.Constants;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accountPagesetup() {
		loginpage=homepage.clickOnSpecificFotterWebElement(Constants.MY_ACCOUNT_LINK, Constants.DEFAULT_TIME_OUT);
		accountpage = loginpage.doLogin( prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyAccountPageTitleTest() {
		String actualTile = accountpage.getAccountPageTitle();
		System.out.println("Title of the Account Page is --> " + actualTile);
		Assert.assertEquals(actualTile, Constants.ACCOUNT_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void verifyAccountPageHeaderTest() {
		String actualLink = accountpage.getAccountPageHeader();
		System.out.println("Header of the Account Page is --> " + actualLink);
		Assert.assertEquals(actualLink, Constants.ACCOUNT_PAGE_HEADERLINK);
	}

	@Test(priority = 3)
	public void verifyaccountSectionListTest() {
		List<String> actualaccsecText = accountpage.getAccountSecList();
		Assert.assertEquals(actualaccsecText, Constants.accountsecList());
		// This is for my reference
		// if(actualaccsecText.equals(Constants.accountsecList())) {
		// System.out.println("Both list are same");
		// }else {
		// System.out.println("Both list are not same");
	}

	@DataProvider
	public Object[][] setdataforSearchProduct() {
		return new Object[][] { { "MacBook Pro" }, { "Apple" }, { "Samsung" } };
	}

	@Test(priority = 5, dataProvider = "setdataforSearchProduct")
	public void verifySearchTest(String productname) {
		searchresultpage = accountpage.doSearch(productname);
	}

	@DataProvider
	public Object[][] setdataforSearchProductAndSearchMainProduct() {
		return new Object[][] { { "MacBook", "MacBook Air" }, 
													 { "Apple", "Apple Cinema 30\"" },
													 { "Samsung", "Samsung Galaxy Tab 10.1" }

		};
	}

	@Test(priority = 6, dataProvider = "setdataforSearchProductAndSearchMainProduct")
	public void selectProductTest(String productName, String mainproductname) {
		searchresultpage = accountpage.doSearch(productName);
		productinfopage = searchresultpage.searchProduct(mainproductname);
		String actualheadrer = productinfopage.getProductHeader();
		Assert.assertEquals(actualheadrer, mainproductname);
//			boolean flag=productinfopage.isAddToCartbtnDisplayed();
//			Assert.assertTrue(flag);

	}

}