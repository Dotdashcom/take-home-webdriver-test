package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import testBase.TestBase;

public class LoginTests extends TestBase {
	LoginPage lp;
	
	public LoginTests() {
		super();
		lp = new LoginPage();
	}

	@BeforeTest
	public void beforeLoginTests() {
		setup();
		driver.get("http://localhost:7080/login");
	}
	
	@AfterTest
	public void afterloginTests() {
		teardown();
	}
	
	@Test(priority = 1)
	public void loginSuccessTest() {
		lp.inputUsername("tomsmith");
		lp.inputPassword("SuperSecretPassword!");
		lp.clickLoginBtn();
		Assert.assertEquals(driver.findElement(By.xpath("//h4[contains(text(),'Welcome to the Secure Area.')]")).getText(), "Welcome to the Secure Area. When you are done click logout below.");
	}
	
	@Test(priority = 2)
	public void loginFailureTest() {
		lp.inputUsername("username");
		lp.inputPassword("password");
		lp.clickLoginBtn();
		WebElement actualFlashMsg = driver.findElement(By.id("flash"));
		Assert.assertTrue(actualFlashMsg.getText().contains("Your username is invalid!"));
	}
	
}
