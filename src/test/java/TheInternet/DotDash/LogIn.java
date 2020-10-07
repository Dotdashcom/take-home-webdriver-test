package TheInternet.DotDash;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class LogIn extends base {

	@Test
	public void LogInTest() {
		driver.get(URL + "login ");
		PageObject driver1 = new PageObject(driver);
		String username2 = driver1.username2();
		String password2 = driver1.Password2();
		driver1.UserName().sendKeys(username2);
		driver1.Password().sendKeys(password2);
		driver1.LogInButton().click();
		String AuthMessage = driver1.text();
		assertEquals(AuthMessage, "Welcome to the Secure Area. When you are done click logout below.");
		driver1.LogOutButton().click();
		driver.close();
	}

}
