package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;

public class IframePage extends BaseTest {

	private By iframe1 = By.id("mce_0_ifr");
	private By closeBtn = By.cssSelector("[aria-label='Close']");
	private By textField = By.id("tinymce");
	private By textTyped = By.cssSelector("#tinymce > p");

	public void testTypingInIframe() {
		
		driver.findElement(closeBtn).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe1));

		driver.findElement(textField).clear();
		driver.findElement(textField).sendKeys("Test text.");
		Assert.assertEquals(driver.findElement(textTyped).getText().trim(), "Test text.");
	}

}
