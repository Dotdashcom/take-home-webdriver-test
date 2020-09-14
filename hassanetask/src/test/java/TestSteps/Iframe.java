package TestSteps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BrowserFactory;

public class Iframe {

	WebDriver driver;

	@BeforeMethod
	public void launchbrowser() {
		// launch browser
		driver = BrowserFactory.startBrowser();
		driver.get("http://localhost:7080/iframe");
		driver.manage().window().maximize();
		
	}

	@Test
	public void handleIframe() throws Exception {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.tagName("body")).sendKeys(Keys.ENTER);;

		driver.findElement(By.tagName("body")).sendKeys("hello this is hassane ");
        
		
		driver.switchTo().defaultContent();

	}


	@AfterMethod
	public void teardown() {
		driver.close();
		// driver.quit();
	}

}
