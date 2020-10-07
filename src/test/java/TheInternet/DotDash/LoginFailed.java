package TheInternet.DotDash;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class LoginFailed extends base {

	@Test
	public void LoginFailedTest() {
		driver.get(URL + "login");
		PageObject driver1 = new PageObject(driver);
		String UserName = driver1.username1();
		String Password = driver1.Password1();
		driver1.UserName().sendKeys(UserName);
		driver1.Password().sendKeys(Password);
		driver1.LogInButton().click();
		String errorMessage = driver1.FlashMessages();
		assertTrue(errorMessage.contains("Your username is invalid!"));
		driver.close();

	}

}
