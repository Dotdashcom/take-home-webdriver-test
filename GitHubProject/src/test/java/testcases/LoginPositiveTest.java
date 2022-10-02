package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import org.testng.Assert;

public class LoginPositiveTest extends BaseTestMethods {
	

  @Test
  public void Test() throws InterruptedException {
	  
	  driver.get("http://localhost:7080/login");
	  LoginPage obj =new LoginPage(driver);
	 
	  String actualuser ="tomsmith";
	  String password="SuperSecretPassword!";
	  
	  obj.printUsername(actualuser);
	  obj.printPassword(password);
	  obj.clickLogin();
	  
	  boolean value =(driver.getPageSource().contains("Secure Area"));
	  System.out.println(value);
	  Assert.assertEquals(value, true);
	  
  }


}
