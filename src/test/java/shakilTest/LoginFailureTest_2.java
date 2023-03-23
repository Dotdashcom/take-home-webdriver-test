package shakilTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFailureTest_2 extends TestBase {
	
	@Test
	public void loginFailureTest() {
		driver.get("http://localhost:7080/login");
		driver.findElement(By.id("username")).sendKeys("ABCD");
		driver.findElement(By.id("password")).sendKeys("SuperSecretABCD");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		WebElement loginConfirmationElement = driver.findElement(By.cssSelector("div#flash"));
		String loginConfirmationString = loginConfirmationElement.getText().replaceAll("[^\\p{Print}]", "");
		Assert.assertEquals(loginConfirmationString.trim(), "Your username is invalid!");

	}
}
