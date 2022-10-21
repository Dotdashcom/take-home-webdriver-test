package PageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FloatingMenuPO {

	WebDriver driver;
	public FloatingMenuPO(WebDriver driver) {
		this.driver= driver;
	}
		
	public void floatingMenu() throws InterruptedException
	{
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,450)", "");
			WebElement HomeButton = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
			assertTrue(HomeButton.isDisplayed());

	}
	
	}
	
	


