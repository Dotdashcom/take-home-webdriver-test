package TestSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BrowserFactory;

public class DynamicControl {

	WebDriver driver;
	WebDriverWait wait;
	@BeforeMethod
	public void launchbrowser() {
		// launch browser
		driver = BrowserFactory.startBrowser();
		driver.get("http://localhost:7080/dynamic_controls");
		driver.manage().window().maximize();
		 wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void add_remove() throws Exception {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
		WebElement add = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
		WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"checkbox\"]/input"));
		WebDriverWait wait = new WebDriverWait(driver, 10);

		checkbox.click();

		element.click();

		wait.until(ExpectedConditions.visibilityOf(add));
		Thread.sleep(3000);

		add.click();

		wait.until(ExpectedConditions.visibilityOf(element));

		Thread.sleep(3000);
	}
	@Test
	public void enable_desable() throws Exception {
	WebElement enableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
	WebElement desableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
	WebElement inputfield = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
		
	enableButton.click();
	Thread.sleep(3000);
	Assert.assertTrue(inputfield.isEnabled());
	
	desableButton.click();
	Assert.assertTrue(enableButton.isDisplayed());
	Thread.sleep(3000);
	}

	@AfterMethod
	public void teardown() {
		driver.close();
		// driver.quit();
	}

}
