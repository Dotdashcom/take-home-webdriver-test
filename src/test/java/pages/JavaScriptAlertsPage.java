package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;

public class JavaScriptAlertsPage extends BaseTest {

	private By jsAlertBtn = By.cssSelector("button[onclick='jsAlert()']");
	private By jsConfirmBtn = By.cssSelector("button[onclick='jsConfirm()']");
	private By jsPromptBtn = By.cssSelector("button[onclick='jsPrompt()']");
	private By resultText = By.id("result");

	public void clickAndassertAlertBth() {
		driver.findElement(jsAlertBtn).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertEquals(alert.getText().trim(), "I am a JS Alert", "Alert message verification");
		alert.accept();
	}

	public void clickAndassertConfirmBth() {
		driver.findElement(jsConfirmBtn).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertEquals(alert.getText().trim(), "I am a JS Confirm", "Confirm Alert message verification");
		alert.accept();
	}

	public void clickAssertAndTypePromptBth(String message) {
		driver.findElement(jsPromptBtn).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertEquals(alert.getText().trim(), "I am a JS prompt", "Prompt Alert message verification");
		alert.sendKeys(message);
		alert.accept();
		Assert.assertTrue(driver.findElement(resultText).getText().trim().contains(message));
		
	
	}

}
