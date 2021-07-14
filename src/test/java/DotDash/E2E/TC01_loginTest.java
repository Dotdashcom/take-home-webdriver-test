package DotDash.E2E;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pageObjects.TC01_loginObjects;
import resources.base;

public class TC01_loginTest extends base{
	@BeforeTest
	public void setup() {
		driver = initializeDriver();
	}
	
	@Test(dataProvider = "getData")
	public void loginSuccess(String username, String password, String expectedMessage) throws InterruptedException {
		TC01_loginObjects lp = new TC01_loginObjects(driver);
		lp.getloginLink().click();
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLoginSubmit().click();
		String msg = lp.getSuccessMessage().getText();
		//check if user is login
		AssertJUnit.assertTrue(msg.contains(expectedMessage));
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][3];
		data[0][0] = "tomsmith";
		data[0][1] = "SuperSecretPassword!";
		data[0][2] = "Welcome to the Secure Area. When you are done click logout below.";
		return data;
	}
}
