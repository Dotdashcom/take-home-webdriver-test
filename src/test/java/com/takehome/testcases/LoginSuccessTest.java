package com.takehome.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.takehome.base.DriverScript;
import com.takehome.pages.Loginpage;

public class LoginSuccessTest {

	DriverScript driverSetup;
	Loginpage page;

	@BeforeTest
	public void setup() {
		driverSetup = new DriverScript();
	}

	@Test(dataProvider = "logindataprovider", dataProviderClass = com.takehome.dataproviders.TestCaseDataProvider.class)
	public void loginSuccess(String name, String pwd) {

		page = new Loginpage(driverSetup.getDriver(), driverSetup.getBaseURL());
		page.login(name, pwd);
		String expectedResultURL = "http://localhost:7080/secure";
		Assert.assertEquals(driverSetup.getDriver().getCurrentUrl(), expectedResultURL);

	}

	@AfterTest
	public void teardown() {
		driverSetup.getDriver().close();
	}

}
