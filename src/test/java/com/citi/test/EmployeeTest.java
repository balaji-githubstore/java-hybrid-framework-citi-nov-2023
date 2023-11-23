
package com.citi.test;

import org.testng.annotations.Test;

import com.citi.base.AutomationWrapper;
import com.citi.pages.LoginPage;

public class EmployeeTest extends AutomationWrapper {
	
	@Test
	public void addValidEmployeeTest()
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername("Admin");
		loginPage.enterPassword("admin123");
		loginPage.clickOnLogin();
		
		//click on PIM
		//click on Add Employee
		//enter first, middle,lastname
		//assert the first and lastname in profile
	}

}
