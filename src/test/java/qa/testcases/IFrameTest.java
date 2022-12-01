package qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;

public class IFrameTest extends TestBase{

	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test
    public void iFrameTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/iframe");
		
		driver.switchTo().frame("mce_0_ifr");
		//driver.findElement(By.xpath("//div[@role='alert']/button/div")).click();
		WebElement addText = driver.findElement(By.cssSelector("body"));
		addText.clear();
		addText.sendKeys("Hello World!");
		Thread.sleep(1000);
		System.out.println(addText.getText());
		Assert.assertEquals(addText.getText(), "Hello World!");
		
	}
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
}
