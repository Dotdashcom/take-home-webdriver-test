package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class TC_LoginPage extends BaseClass {
	

	@Test
	public void VerifyLoginPass()
	{
		LoginPage lp = new LoginPage(driver);
		
		driver.get("http://localhost:7080/login");
		lp.EnterUserName("tomsmith");
		lp.EnterPassword("SuperSecretPassword!");
		lp.ClickLogin();
		String newurl = driver.getCurrentUrl();
        Assert.assertEquals(newurl,"http://localhost:7080/secure");
        
	}
        
        
        @Test 
        public void VerifyLoginFailure() {
        	driver.get("http://localhost:7080/login");
        	LoginPage lp = new LoginPage(driver);
        	lp.EnterUserName("tomsmith");
    		lp.EnterPassword("SuperSecretPasswordss!");
    		lp.ClickLogin();
            String newurl = driver.getCurrentUrl();
            Assert.assertEquals(newurl,"http://localhost:7080/login");
        }

}
