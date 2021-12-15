package com.qa.opencart.tests;


import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductInfoPageTest  extends BaseTest{
	
	@BeforeClass
	public void ProductInfoPagesetup() {
		accountpage = loginpage.doLogin( prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@DataProvider
	public Object[][] setdataforSearchProductAndSearchMainProduct() {
		return new Object[][] { { "MacBook", "MacBook Air" }, 
													 { "Apple", "Apple Cinema 30\"" },
													 { "Samsung", "Samsung Galaxy Tab 10.1" }

		};
	}

	@Test(priority = 1, dataProvider = "setdataforSearchProductAndSearchMainProduct")
	public void selectProductTest(String productName, String mainproductname) {
		searchresultpage = accountpage.doSearch(productName);
		productinfopage = searchresultpage.searchProduct(mainproductname);
		String actualheadrer = productinfopage.getProductHeader();
		Assert.assertEquals(actualheadrer, mainproductname);
//			boolean flag=productinfopage.isAddToCartbtnDisplayed();
//			Assert.assertTrue(flag);

	}
	
	@Test(priority = 2, dataProvider = "setdataforSearchProductAndSearchMainProduct")
	public void verifyProductMetaData(String productName, String mainproductname) {
		searchresultpage = accountpage.doSearch(productName);
		productinfopage = searchresultpage.searchProduct(mainproductname);
		Map<String,String> actualproduct =productinfopage.getProductInfo();
		actualproduct.forEach((k,v)->System.out.println(k+" : "+v)) ;
		softassert.assertEquals(actualproduct.get("Brand"), "Apple");
		softassert.assertEquals(actualproduct.get("Product Code"), "Product 15");
		softassert.assertEquals(actualproduct.get("Original Price"), "$100.00");
		softassert.assertEquals(actualproduct.get("Reward Points"), "100");
		softassert.assertAll();
		
		
	}

}
