package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;
import utilities.DriverUtility;

public class JavaScriptAlertsTest extends Base {

	@BeforeMethod

	public void beforeMethod() {
		Base.initializeDriver();
		driver.get("http://localhost:7080/javascript_alerts");
	}
//	Test Clicks on JS Alert Button.
//	Test asserts alert message.
//	Test clicks on JS confirm Button and clicks ok on alert.
//	Test asserts the alert message.
//	Test clicks on JS Prompt Button and types a message on Prompt.
//	Test asserts that the alert message contains the typed message.

	@Test
	public void jsAlert() {

		WebElement jsAlertButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
		DriverUtility.clickonElement(jsAlertButton);
		String alertText = driver.switchTo().alert().getText();
		DriverUtility.waitforAlert();
		Assert.assertEquals(alertText, "I am a JS Alert");

	}

	@Test
	public void jsConfirm() {

		WebElement confirmAlertButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
		DriverUtility.clickonElement(confirmAlertButton);
		String alertText = driver.switchTo().alert().getText();
		DriverUtility.waitforAlert();
		DriverUtility.acceptAlert();
		Assert.assertEquals(alertText, "I am a JS Confirm");

	}

	@Test
	public void jsPrompt() {
		String message = "Testing";
		WebElement promptButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
		DriverUtility.clickonElement(promptButton);
		String alertText = driver.switchTo().alert().getText();
		DriverUtility.waitforAlert();
		driver.switchTo().alert().sendKeys(message);
		DriverUtility.acceptAlert();
		String msgPrompt = driver.switchTo().alert().getText();
		Assert.assertEquals(msgPrompt, message);

	}

}
