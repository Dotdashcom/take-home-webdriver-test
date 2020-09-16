package TestSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BrowserFactory;

public class LoginTest {
	WebDriver driver;

	@BeforeMethod
	public void launchbrowser() {
		// launch browser
		driver = BrowserFactory.startBrowser();
		driver.get("http://localhost:7080/login");
		driver.manage().window().maximize();

	}

	// first testcase (valid username and valid password)
	@Test(priority = 1)
	public void login_with_valid_credencials() throws Exception {// *[@id="content"]/div/h4

		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button.radius")).click();
		String actualmessage = driver.findElement(By.xpath("//h4[@class ='subheader']")).getText();
		String expectedmessage = "Welcome to the Secure Area. When you are done click logout below.";
		Assert.assertEquals(actualmessage, expectedmessage);

		Thread.sleep(3000);
	}

	// second testcase (valid username and invalid password)
	@Test(priority = 2)
	public void Login_with_invalid_credencials() throws Exception {
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecret");
		driver.findElement(By.cssSelector("button.radius")).click();

		WebElement error_message = driver.findElement(By.id("flash"));
		error_message.isDisplayed();

		Thread.sleep(3000);
	}

	@AfterMethod
	public void teardown() {
		driver.close();
		// driver.quit();
	}

}
