package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.opencart.utility.ConstantsOpenCart;
import com.qa.opencart.utility.ExcelUtility;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void setupRegisterPageTest() {
		loginpage = homepage.clickOnSpecificFotterWebElement(ConstantsOpenCart.MY_ACCOUNT_LINK, ConstantsOpenCart.DEFAULT_TIME_OUT);
		registerpage = loginpage.clickOnRegisterLinks();
	}

	@DataProvider
	public Object[][] getRegisterData() {
		return ExcelUtility.getTestData("registration");
	}

	@Test(dataProvider = "getRegisterData")
	public void registrationPageTest(String fName, String lName, String email, String telephone, String password,String subscribe) {
		registersuccesspage = registerpage.fillPersonalDetails(fName, lName, email, telephone, password, subscribe);

		String actualText = registersuccesspage.getText_Your_Account_Has_Been_Created();
		if (actualText.equals(ConstantsOpenCart.REGISTER_SUCCESS_PAGE_TEXT)) {
			accountpage.logout();
			loginpage.clickOnRegisterLinks();
			Assert.assertEquals(actualText, ConstantsOpenCart.REGISTER_SUCCESS_PAGE_TEXT);
		}
		Assert.assertEquals(actualText, ConstantsOpenCart.REGISTER_SUCCESS_PAGE_TEXT);
	}

}
