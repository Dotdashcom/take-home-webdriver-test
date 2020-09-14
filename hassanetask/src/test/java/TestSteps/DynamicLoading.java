package TestSteps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BrowserFactory;

public class DynamicLoading {
	WebDriver driver;

	@BeforeMethod
	public void launchbrowser() throws Exception {
		// launch browser
		driver = BrowserFactory.startBrowser();
		driver.get("http://localhost:7080/dynamic_loading/2");
		Thread.sleep(5000);
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Test
	public void load() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement  element = driver.findElement(By.xpath("//*[@id='start']/button"));
		wait.until(ExpectedConditions.visibilityOf(element));		
		element.click();
		String expected = "Hello World!";
		String actaul = driver.findElement(By.id("finish")).getText();
		Assert.assertTrue(actaul.contains(expected));
		Thread.sleep(3000);
	
	}

	 @AfterMethod
		public void teardown() {
			driver.close();
			// driver.quit();
		
}
}
