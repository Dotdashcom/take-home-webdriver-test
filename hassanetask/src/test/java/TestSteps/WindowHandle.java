package TestSteps;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BrowserFactory;

public class WindowHandle {
WebDriver driver;
	@BeforeMethod
	public void launchbrowser() {
		// launch browser
		driver = BrowserFactory.startBrowser();
		driver.get("http://localhost:7080/windows");
		driver.manage().window().maximize();

	}
	@Test
	public void window() {
		//firs way
		driver.findElement(By.partialLinkText("Click Here")).click();
		String parentwindow = driver.getWindowHandle();
		Set<String> iterator = driver.getWindowHandles();
		for(String window:iterator) {
			if(!(parentwindow.equalsIgnoreCase(window)))
			driver.switchTo().window(window);
		}
		
		String actualtitle =driver.getTitle();
		String expectedtitle = "New Window";
		Assert.assertEquals(actualtitle, expectedtitle);
		
		
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
		 driver.quit();
	}
	
	
}
