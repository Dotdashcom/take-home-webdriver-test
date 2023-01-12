package staffitsolution.qa.wlctointernet.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;
import staffitsolution.qa.wlctointernet.constants.Constants;

public class LoginPage_InvalidTest extends BaseTest {

	private By loginfailuremsg = By.xpath("//div[@class='flash error']");
	
	@Test
	public void loginPageTitleTest()
	{
		String loginTitle=loginPage_Valid.getLoginPageTitle();
		System.out.println("Login Page title:" + loginTitle);
		Assert.assertEquals(loginTitle, Constants.LOGIN_PAGE_TITLE);
		
	}
	
	

@Test
public void InValidloginTest() {
	driver.get(prop.getProperty("loginurl"));
	loginPage_Valid.dologin(prop.getProperty("InValid_username").trim(),prop.getProperty("InValid_password").trim());	
	Assert.assertTrue(driver.findElement(loginfailuremsg).getText().trim().contains(Constants.loginfail));
	
	}
	
}
