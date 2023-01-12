package staffitsolution.qa.wlctointernet.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;

public class ContextMenuTest extends BaseTest {
	@Test(priority = 1)
	public void selCheckBoxTest() throws InterruptedException {
		driver.get(prop.getProperty("contextlinkurl"));
		Thread.sleep(2000);
		WebElement rightclick = driver.findElement(By.xpath("//div[@id='hot-spot']"));
		WebElement h3 = driver.findElement(By.xpath("//h3"));
		// Perform right click operation
		Actions act = new Actions(driver);
		act.contextClick(rightclick).perform();

		// Handle Alert
		Alert al = driver.switchTo().alert();
		Thread.sleep(2000);
		String alerttext = al.getText();
		System.out.println("Alert box text message is: " + alerttext);
		Assert.assertEquals(alerttext, "You selected a context menu");
		al.accept();
		driver.findElement(By.xpath("//body")).click();

	}
}