package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;

public class DynamicLoadingPage extends BaseTest {

	private By startBtn = By.xpath("//button[contains(text(),'Start')]");
	private By resultingText = By.cssSelector("#finish > h4");

	public void dynamicLoadingUsingExplictWaits() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(startBtn).click();
		Assert.assertTrue(wait.until(ExpectedConditions.textToBe(resultingText, "Hello World!")));
	}

}
