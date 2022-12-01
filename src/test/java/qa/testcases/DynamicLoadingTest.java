package qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;

public class DynamicLoadingTest extends TestBase{

	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test
    public void dynamicLoadingTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/dynamic_loading/2");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));
		
		Assert.assertEquals(driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]")).getText(), "Hello World!");
	}
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
	
}
