package TestSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BrowserFactory;

public class JsAlerts {
	WebDriver driver;
	Actions action ;

	@BeforeMethod
	public void launchbrowser() {
		// launch browser
		driver = BrowserFactory.startBrowser();
		driver.get("http://localhost:7080/javascript_alerts");
		driver.manage().window().maximize();
		action = new Actions(driver);
	}

	@Test
	public void js_alert() throws Exception {

		driver.findElement(By.xpath("//button[contains (text(),'Click for JS Alert')]")).click();
		Thread.sleep(3000);
        driver.switchTo().alert().accept();
        String actualmessage = driver.findElement(By.id("result")).getText();
        String expectedmessage= "You successfuly clicked an alert";
        Assert.assertEquals(actualmessage, expectedmessage);;
        
	}
	@Test
	public void js_confirm() throws Exception {

		driver.findElement(By.xpath("//button[contains (text(),'Click for JS Confirm')]")).click();
		Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        String actualmessage = driver.findElement(By.id("result")).getText();
        String expectedmessage= "You clicked: Cancel";
        Assert.assertEquals(actualmessage, expectedmessage);;
        Thread.sleep(3000);
	}
	@Test
	public void js_prompt() throws Exception {

		driver.findElement(By.xpath("//button[contains (text(),'Click for JS Prompt')]")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().getText();
		driver.switchTo().alert().sendKeys("hello world");
        driver.switchTo().alert().accept();
        String actualmessage = driver.findElement(By.xpath("//p[contains(text(),'entered')]")).getText();
        Assert.assertTrue(actualmessage.contains(":"));;
        Thread.sleep(3000);
	}

	@AfterMethod
	public void teardown() {
		driver.close();
		// driver.quit();
	}
}
