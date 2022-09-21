package com.localhost7080.qa;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dotdashmeredith.base.Base_DDM;
import com.dotdashmeredith.base.GlobalVariables;
import com.localhost7080.ddm.ObjectsAndMethods;

public class TC02_LoginFailure {

	public static void main(String[] args) {
		
		beforeTest();
		LoginFailure_Steps();	
		afterTest();

	}
	
	static WebDriver driver;
	static Base_DDM base;
	static ObjectsAndMethods page;

	@BeforeTest
	public static void beforeTest() {
		base = new Base_DDM(driver);
		driver = base.chromeDriver();
		page = new ObjectsAndMethods(driver);
	}

	@Test
	public static void LoginFailure_Steps() {

		// Step 1. Launch browser and maximize window
		base.launchBrowser(GlobalVariables.URL_LOCALHOST);

		// Step 2. Enter wrong credentials and validate informative text
		page.enterWrongCredentials("Jorge", "ABC123", GlobalVariables.EXPECTED_DATA_FAILURE);

	}
	
	 @AfterTest
	  public static void afterTest() {
		  
		  driver.close();
		  
	  }

}
