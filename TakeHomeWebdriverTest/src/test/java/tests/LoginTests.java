package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class LoginTests extends TestBase {

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
		//driver.findElement(By.xpath("//a[contains(text(),'Form Authentication')]")).click();
		driver.findElement(By.name("username")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//h4[contains(text(),'Welcome to the Secure Area.')]")).getText(), "Welcome to the Secure Area. When you are done click logout below.");
	}
	
	@Test(priority = 2)
	public void loginFailureTest() {
		driver.findElement(By.xpath("//a[@class='button secondary radius']")).click();
		driver.findElement(By.name("username")).sendKeys("username");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
		WebElement actualFlashMsg = driver.findElement(By.id("flash"));
		Assert.assertTrue(actualFlashMsg.getText().contains("Your username is invalid!"));
	}
	
}
