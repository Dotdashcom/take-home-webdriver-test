package TheInternet.DotDash;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class JavaScripts extends base {
	
	@Test
	public void JavaScriptsTest() throws InterruptedException {
		driver.get(URL + "javascript_alerts ");
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		String JavaAlertText1 = driver.switchTo().alert().getText();
		assertEquals(JavaAlertText1, "I am a JS Alert");
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		String JavaAlertText2 = driver.switchTo().alert().getText();
		assertEquals(JavaAlertText2, "I am a JS Confirm");
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		String Text = "Hi I am Testing Alerts";
		driver.switchTo().alert().sendKeys(Text);
		driver.switchTo().alert().accept();
		String TextMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
		assertTrue(TextMessage.contains(Text));

	}

}
