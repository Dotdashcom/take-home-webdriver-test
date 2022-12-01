package qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;

public class NotificationTest extends TestBase {

	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test
    public void notificationTest() throws InterruptedException  {
		
		driver.get(prop.getProperty("baseurl")+"/notification_message_rendered");
		
		for(int i=1; i<=3; i++) {
			WebElement clickHereLink = driver.findElement(By.xpath("//a[contains(text(),'Click here')]"));
			clickHereLink.click();
			Thread.sleep(1000);
			//String click_msg = driver.findElement(By.xpath("//div[@id='flash']")).getText();
			//System.out.println(click_msg);
		}
		
		String click_msg = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		//System.out.println(click_msg);
		String msg = click_msg.substring(0, click_msg.length()-2);
		boolean result = msg.equals("Action unsuccesful, please try again") || msg.equals("Action successful") || msg.equals("Action Unsuccessful"); 
		Assert.assertTrue(result);
	}
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
}
