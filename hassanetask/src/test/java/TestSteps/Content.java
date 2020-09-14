package TestSteps;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BrowserFactory;

public class Content {
WebDriver driver;
	
	
	
	@BeforeMethod
	public void launchbrowser() {
		// launch browser
		driver = BrowserFactory.startBrowser();
		driver.get("http://localhost:7080/dynamic_content");
		driver.manage().window().maximize();

	}
	@Test
	public void dynamic_content() {
		
		
		driver.findElement(By.xpath("//*[contains(text(),'click here')]")).click();
		driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]")).isDisplayed();
		
	}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
		 driver.quit();
	}
}
