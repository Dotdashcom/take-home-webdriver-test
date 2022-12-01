package qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;

public class MouseHoverTest extends TestBase{

	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test 
    public void mouseHoverTest() throws InterruptedException {
		
		driver.get(prop.getProperty("baseurl")+"/hovers");
		
		WebElement img1 = driver.findElement(By.xpath("//div[@class='figure'][1]"));
		WebElement img2 = driver.findElement(By.xpath("//div[@class='figure'][2]"));
		WebElement img3 = driver.findElement(By.xpath("//div[@class='figure'][3]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(img1).build().perform();
		Assert.assertEquals(driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]")).getText(), "name: user1");
		
		Thread.sleep(1000);
		action.moveToElement(img2).build().perform();
		Assert.assertEquals(driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]")).getText(), "name: user2");

		Thread.sleep(1000);
		action.moveToElement(img3).build().perform();
		Assert.assertEquals(driver.findElement(By.xpath("//h5[contains(text(),'name: user3')]")).getText(), "name: user3");
	}
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
}
