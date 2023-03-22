package com.test.TakeHomeShivam;

import org.testng.annotations.Test;

import com.main.TakeHomeShivam.ExcelReader;
import com.main.TakeHomeShivam.LoginPage;
import com.main.TakeHomeShivam.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends TestBase {

	private LoginPage loginPage;
	private ExcelReader excelreader = new ExcelReader();

	@BeforeMethod
	public void beforeMethod() {
		init("login");
	}

	@DataProvider(name = "user-data")
	public Object[][] excel_data_provider() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] arrObj = excelreader.getExcelData("./testdata.xlsx", "UserData");
		return arrObj;
	}

	// Script
	@Test(dataProvider = "user-data")
	public void TC_001_TestLoginSuccess(String username, String password, String scenario) throws IOException {
		loginPage = new LoginPage(getDriver());
		loginPage.login(username, password);
		if(scenario == "valid") {
			Assert.assertTrue(loginPage.successLoginMessageDisplayed());
		}else {
			Assert.assertTrue(loginPage.failureLoginMessageDisplayed());
		}
	}

	@AfterMethod
	public void afterMethod() {
		getDriver().quit();
	}

}
