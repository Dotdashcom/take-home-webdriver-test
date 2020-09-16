package main.java;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginPagge {
	
	WebDriver driver;
	
	public void LoginUsingPageFactory(WebDriver testdriver) {
		this.driver=testdriver;
	}
	
	@FindBy(id="username")
	WebElement user;
    
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@class=\"radius\"]/i")
	WebElement signon;
	
	@FindBy(xpath="//div[@class=\"example\"]/h4")
	WebElement welcome;
	
	public void logincredentials(String uname,String pass)
	{
		
		user.sendKeys(uname);
		password.sendKeys(pass);
		signon.click();
		
		String expected="Welcome to the Secure Area. When you are done click logout below.";
		String actual=welcome.getText();
		
		SoftAssert softassert=new SoftAssert();
		
		softassert.assertEquals(actual, expected,"Please enter valid username and password");
		
		if(actual.contains("Welcome"))
		{
			System.out.println("Login Valid");
		}
		else
		{
		System.out.println("Login InValid but Test passed");
		}
		//softassert.assertAll();
	}
}
