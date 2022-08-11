package Test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Util.MainClass;

public class DynamicLaodingTest extends MainClass{

	@Before
    public void Setup()
	{
		startBrowser();
	}
	
	@Test
	public void verify_DynamicLoading()
	{
		driver.get(" http://localhost:7080/dynamic_loading/2");
		WebElement startButton = driver.findElement(By.xpath("//*[@id='start']/button"));

		startButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));	
		//Asserts previous validation with “Hello World!” text is displayed.
		assertTrue(true);
	}
	@After 
    public void tearDown() 
    {
    	closeBrowser();
    }

}
