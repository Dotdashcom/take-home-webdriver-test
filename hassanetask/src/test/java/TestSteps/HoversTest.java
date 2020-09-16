package TestSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BrowserFactory;

public class HoversTest {

	WebDriver driver;
	@BeforeMethod
	public void launchbrowser() {
		// launch browser
		driver = BrowserFactory.startBrowser();
		driver.get("http://localhost:7080/hovers");
		driver.manage().window().maximize();

	}
	@Test
	public void mousehover() throws Exception {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
		Actions action = new Actions (driver);
		action.moveToElement(element).build().perform();
		String actualtext = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/h5")).getText();
		String expectedtext = "name: user1";
		Assert.assertEquals(actualtext, expectedtext);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
		// driver.quit();
	}
}
