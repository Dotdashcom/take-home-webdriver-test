package shakilTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginSuccessTest_1 extends TestBase {
	
	@Test
	public void loginSuccessTest() {
		driver.get("http://localhost:7080/login");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		WebElement loginConfirmationElement = driver.findElement(By.cssSelector("#flash-messages .success"));
		String loginConfirmationString = loginConfirmationElement.getText().replaceAll("[^\\p{Print}]", "");
		Assert.assertEquals(loginConfirmationString.trim(), "You logged into a secure area!");

	}
}
