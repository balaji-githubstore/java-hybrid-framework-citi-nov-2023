package com.citi.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.citi.base.AutomationWrapper;
import com.citi.pages.DashboardPage;
import com.citi.pages.LoginPage;
import com.citi.utils.DataUtils;

public class LoginTest extends AutomationWrapper {

	@Test
	public void validLoginTest() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsername("Admin");
		loginPage.enterPassword("admin123");
		loginPage.clickOnLogin();

		DashboardPage dashboardPage = new DashboardPage(driver);

		String actualHeader = dashboardPage.getDashboardHeader();
		Assert.assertEquals(actualHeader, "Dashboard");
	}

	@Test(dataProvider = "invalidLoginData",dataProviderClass = DataUtils.class)
	public void invalidLoginTest(String username, String password, String expectedError) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLogin();

		String actualError = loginPage.getInvalidErrorMessage();
		Assert.assertEquals(actualError, expectedError);
	}
}
