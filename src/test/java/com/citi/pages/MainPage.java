package com.citi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * All menu and common elements will be handled
 */
public class MainPage {
	
	private WebDriver driver;
	
	public MainPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickOnPIMMenu()
	{
		driver.findElement(By.xpath("")).click();
	}

}
