package atsTest;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest {
	 	
      //login success	
	  @Test
	  public void testLoginSuccess() {
		driver.get("http://localhost:7080/login");
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.loginUser("tomsmith", "SuperSecretPassword!");
		assertEquals(homePage.getMessageText(),"Secure Area");
	    
	  }
	  
	  //login failure
	   public void testLoginFailure() {
		driver.get("http://localhost:7080/login");
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.loginUser("tom", "SuperSecretPassword!");
	    assertNotSame(homePage.getInvalidMessageText(),"Secure Area");
	        
		  }
	
}
