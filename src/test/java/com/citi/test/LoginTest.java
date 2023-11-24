package com.citi.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.citi.base.AutomationWrapper;
import com.citi.pages.DashboardPage;
import com.citi.pages.LoginPage;
import com.citi.utils.DataUtils;

public class LoginTest extends AutomationWrapper {

	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataUtils.class,groups = {"login","smoke"})
	public void validLoginTest(String username,String password,String expectedHeader) {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLogin();

		DashboardPage dashboardPage = new DashboardPage(driver);

		String actualHeader = dashboardPage.getDashboardHeader();
		Assert.assertEquals(actualHeader, expectedHeader);
	}

	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataUtils.class,groups = {"login"})
	public void invalidLoginTest(String username, String password, String expectedError) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLogin();

		String actualError = loginPage.getInvalidErrorMessage();
		Assert.assertEquals(actualError, expectedError);
	}
}
