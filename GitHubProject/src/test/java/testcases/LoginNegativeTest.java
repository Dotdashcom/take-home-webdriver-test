package testcases;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.testng.Assert;


public class LoginNegativeTest extends BaseTestMethods {
	
	
	

  @Test
  public void Test() throws InterruptedException {
	  
	  LoginPage obj = new LoginPage(driver);
	  
	  driver.get("http://localhost:7080/login");
	  String wrongUser ="toms";
	  String wrongPassword="Super!";
	  
	  obj.printUsername(wrongUser);
	  obj.printPassword(wrongPassword);
	  obj.clickLogin();
	  
	  boolean value =(driver.getPageSource().contains("Secure Area"));
	  System.out.println(value);
	  Assert.assertEquals(value, true);
	  		  
  }

}
