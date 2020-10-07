package com.company.Login;


import com.company.Base.BaseUrl;
import com.company.Base.BrowseFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyWordpressLogin {
	
	
	@Test
	public void verifyValidLoginAndLogout() throws Exception
	{
		WebDriver driver= BrowseFactory.StartBrowser(BaseUrl.loginUrl);
		LoginPage loginPage=new LoginPage(driver);
		loginPage.typeUsername();
		loginPage.typePassword();
		loginPage.clickonLoginButton();
		String SuccessMessage = "You logged into a secure area!";

        String FailureMessage = "Your username is invalid!";
        if(loginPage.getTextMessage().getText().contains(SuccessMessage))
        {
        	Assert.assertTrue(true,"LogIn Successfuly");
        	Thread.sleep(5000);
        	loginPage.clickonLogout();
        	System.out.println("User is successfully logged in");
        	
        }
        else if(loginPage.getTextMessage().getText().contains(FailureMessage))
        {
        	Assert.assertTrue(true,"Not LogIn");
        	System.out.println("Not LogIn");
        	Thread.sleep(5000);
        }
        else
        {
        	System.out.println("Something went wrong");
        }
       
		
		
		
		
		
	}

}
