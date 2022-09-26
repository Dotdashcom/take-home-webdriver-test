package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.LoginBaseClass;
import pageClasses.LoginHomePage;


public class SuccessfulLogin extends LoginBaseClass {
	
	@Test
	public void verifySuccessfulLogin() throws InterruptedException {
		
		LoginHomePage lp = new LoginHomePage(driver);
		lp.enterUsername("tomsmith");
		lp.enterPassword("SuperSecretPassword!");
		lp.clickLgnBtn();
				
		String successfulLogin_actualtitle = driver.getTitle();
		System.out.println("Actual title is: " + successfulLogin_actualtitle);
		String successfulLogin_expectedtitle = "The Internet";
		Assert.assertEquals(successfulLogin_actualtitle, successfulLogin_expectedtitle);
	}
	
	

}
