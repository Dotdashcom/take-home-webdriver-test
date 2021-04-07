package com.theInternetApp.qa.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.theInternetApp.qa.ApplicationControler.ApplicationController;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
Created by Mustafa SK MD Abdul Hayee on 04/05/2021
*/
public class BaseClass {

	protected static WebDriver driver;
	protected WaitHelper waitHelper = null;
	protected String Base_URL = "http://localhost:7080";
	protected String login_path = "/login";

	@BeforeClass
	public void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeMethod
	public void setupTest() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@AfterMethod
	public void after() {
		// driver.quit();
		// driver.close();
	}

	// Application Controller
	public ApplicationController theInternetApp() {
		return new ApplicationController(driver);
	}

}
