package qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;

public class FloatingMenuTest extends TestBase{

	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test
    public void floatingMenuTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/floating_menu");
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,5000)");
		Thread.sleep(1000);
		WebElement floating_menu = driver.findElement(By.xpath("//div[@id='menu']"));
		Assert.assertEquals(floating_menu.isDisplayed() , true);
	}
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
}
