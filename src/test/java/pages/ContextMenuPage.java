package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;

public class ContextMenuPage extends BaseTest {

	private By theBox = By.cssSelector("#hot-spot");

	public void clickTheBoxAndAssertAlert(String expectedMessage) {
		Actions actions = new Actions(driver);
		actions.contextClick(driver.findElement(theBox)).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String text = alert.getText();
		Assert.assertEquals(text.trim(), expectedMessage, "Alert message verification");
		alert.accept();

	}

}
