package qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.TestBase;

public class ContextMenuTest extends TestBase {

	@BeforeMethod
	public void setup() {
		initialization();
	}
	
	@Test 
    public void contextMenu_rightClickTest() throws InterruptedException {
		driver.get(prop.getProperty("baseurl")+"/context_menu");
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		WebElement contextMenu = driver.findElement(By.xpath("//div[@id='hot-spot']"));
		action.contextClick(contextMenu).build().perform();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertEquals("You selected a context menu", alert.getText());
	}
	
	
	@AfterMethod
	public void teardown() {
		closeBrowser();
	}
	
}
