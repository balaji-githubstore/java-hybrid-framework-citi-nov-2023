package com.citi.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
 * will be deleted
 */
public class ZDemo1Test {

	@DataProvider
	public String[][] validDemoData() {
		String[][] data = new String[3][2];
		// i--> number of testcase/number of set of test data
		// j-->number of arguments

		data[0][0] = "kim";
		data[0][1] = "kim123";

		data[1][0] = "saul";
		data[1][1] = "saul123";

		data[2][0] = "peter";
		data[2][1] = "peter123";

		return data;
	}

	@Test(dataProvider = "validDemoData")
	public void validDemoTest(String username, String password) {
		System.out.println("hello "+username+password);
	}

}
