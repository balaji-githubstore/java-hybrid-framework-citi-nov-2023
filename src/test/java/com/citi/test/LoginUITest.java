package com.citi.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.citi.base.AutomationWrapper;
import com.citi.pages.LoginPage;
	
public class LoginUITest extends AutomationWrapper {
	
	@Test(groups = {"ui","smoke"})
	public void titleTest()
	{
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}
	
	@Test(groups = {"ui"})
	public void headerTest()
	{
		LoginPage loginPage=new LoginPage(driver);
		Assert.assertEquals(loginPage.getLoginHeader(), "Login");
	}
}
