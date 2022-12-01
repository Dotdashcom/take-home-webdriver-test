package qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;

public class JavaScriptAlertTest extends TestBase{
	
	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test 
    public void javaScriptAlertTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/javascript_alerts");
		Thread.sleep(1000);
		Alert alert;
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText() , "I am a JS Alert");
		alert.accept();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText() , "I am a JS Confirm");
		alert.accept();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText()	, "You clicked: Ok");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		Thread.sleep(1000);
		String promptMsg = "This is a prompt";
		alert = driver.switchTo().alert();
		alert.sendKeys(promptMsg);
		alert.accept();
		String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String final_result = result.substring(13, result.length());
		Assert.assertEquals(final_result, promptMsg);
	}
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}

}
