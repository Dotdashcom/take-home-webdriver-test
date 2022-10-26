package Testcases;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
public class TC_Login extends Baseclass
{
	@Test
  public void loginTest() 
  {
	driver.get(baseURL); 
	
	LoginPage lp = new LoginPage(driver);
	
	
	lp.setUserName(username);
	lp.setPassword(password);
	lp.Clicksubmit();
	System.out.println("button click");
	
	
	if(driver.getTitle().equals("The Internet"))
	{
		Assert.assertTrue(true);
		System.out.println(driver.getTitle());
	}
	else
	{
		Assert.assertTrue(false);
	}
	}
  }

