package com.automation.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.pageobject.CheckBoxsPage;
import com.automation.pageobject.LoginPage;

public class CheckBox extends BaseTest{
	
	@Test
	public void Checkboxes() {
		
		driver.get(configProperties.getProperty("BaseUrl")+"/checkboxes");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    CheckBoxsPage.validateCheckBoxsHeader(driver);
	    CheckBoxsPage.clickCheckBoxes(driver);
	}
	
}
