package staffitsolution.qa.wlctointernet.test;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;
import staffitsolution.qa.wlctointernet.constants.Constants;


public class LoginPage_ValidTest extends BaseTest {
	
	private By loginsuccessmsg = By.xpath("//div[@class='flash success']");
	
//	@Test
//	public void loginPageTitleTest()
//	{
//		String loginTitle=loginPage_Valid.getLoginPageTitle();
//		System.out.println("Login Page title:" + loginTitle);
//		Assert.assertEquals(loginTitle, "The Internet");
//	}
	@Test(priority=1)
	public void loginTest() {
		driver.get(prop.getProperty("loginurl"));
		loginPage_Valid.dologin(prop.getProperty("Valid_username").trim(),prop.getProperty("Valid_password").trim());
		Assert.assertTrue(driver.findElement(loginsuccessmsg).getText().trim().contains(Constants.loginSuccess));
		
	}


}
