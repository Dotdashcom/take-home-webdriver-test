package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;

public class NotificationMessagePage extends BaseTest {

	private By clickHereLink = By.xpath("//a[contains(text(),'Click here')]");
	private By resultMessage = By.cssSelector("#flash-messages > #flash");

	public void clickLinkVerifyMessages() {
		String[] messages = { "Action Successful", "Action unsuccessful, please try again", "Action Unsuccessful" };
		for (int i = 0; i < messages.length; i++) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(clickHereLink));
			driver.findElement(clickHereLink).click();
			String actualMessage = driver.findElement(resultMessage).getText();
			if(actualMessage.equals(messages[i])) {
				Assert.assertTrue(true);
				break;
			}
		}

	}

}
