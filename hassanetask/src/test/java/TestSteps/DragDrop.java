package TestSteps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BrowserFactory;

public class DragDrop {

	WebDriver driver;
	@BeforeMethod
	public void launchbrowser() {
		// launch browser
		driver = BrowserFactory.startBrowser();
		driver.get("http://localhost:7080/drag_and_drop");
		driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void rightclick() throws Exception {

		WebElement  drag= driver.findElement(By.id("column-a"));
		WebElement  drop = driver.findElement(By.id("column-b"));
		
		Actions action = new Actions(driver);
	   action.dragAndDrop(drag, drop).perform();
	 
	   Thread.sleep(3000);
	
	   /* Action dragdrop = action.clickAndHold(drag).moveToElement(drop).release(drop).build();
	   dragdrop.perform();*/
	   
	}

	@AfterMethod
	public void teardown() {
		driver.close();
		
	}

}
