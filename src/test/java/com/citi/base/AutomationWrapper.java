package com.citi.base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.citi.utils.PropUtils;

public class AutomationWrapper {
	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser" })
	public void setup(@Optional("ch")  String browserName) throws IOException {
		if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("ff")) {
			driver = new FirefoxDriver();

		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String baseUrl=PropUtils.getValue("test-data/data.properties", "url");
		driver.get(baseUrl);
	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {
		driver.quit();
	}

}
