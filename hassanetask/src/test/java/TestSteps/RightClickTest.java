package TestSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BrowserFactory;

public class RightClickTest {
	WebDriver driver;

	@BeforeMethod
	public void launchbrowser() {
		// launch browser
		driver = BrowserFactory.startBrowser();
		driver.get("http://localhost:7080/context_menu");

	}

	@Test
	public void rightclick() throws Exception {

		WebElement element = driver.findElement(By.id("hot-spot"));
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		action.moveByOffset(0, 0).build().perform();
	}

	@AfterMethod
	public void teardown() {
		driver.close();
		// driver.quit();
	}

}
