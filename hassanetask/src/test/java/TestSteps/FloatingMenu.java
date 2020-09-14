package TestSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BrowserFactory;

public class FloatingMenu {

	WebDriver driver;

	@BeforeMethod
	public void launchbrowser() throws Exception {
		// launch browser
		driver = BrowserFactory.startBrowser();
		driver.get("http://localhost:7080/floating_menu#home");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test
	public void floating() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window. scrollBy(0,2000)", "");
		WebElement element = driver.findElement(By.xpath("//*[@id='menu']"));
		 Assert.assertTrue(element.isDisplayed());
	       driver.findElement(By.xpath("//*[@id='menu']/ul/li[1]/a")).click();
	      
		
	}

	@AfterMethod
	public void teardown() {
		driver.close();
		// driver.quit();
	}

}
