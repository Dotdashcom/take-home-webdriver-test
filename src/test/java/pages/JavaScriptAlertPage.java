package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseTest.AbstractE2E;

public class JavaScriptAlertPage {

	WebDriver driver;

	public JavaScriptAlertPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements or locators
	@FindBy(xpath = "//button[contains(text(),'Click for JS Alert')]")
	WebElement JSAlertButton;

	@FindBy(xpath = "//button[contains(text(),'Click for JS Confirm')]")
	WebElement JSConfirmButton;

	@FindBy(xpath = "//button[contains(text(),'Click for JS Prompt')]")
	WebElement JSPromptButton;

	@FindBy(xpath = "//p[@id='result']")
	WebElement result;

	public String clickJSAlertButton() {
		JSAlertButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		driver.switchTo().alert();
		String alertText = driver.switchTo().alert().getText();
		alert.accept();
		return alertText;
	}

	public String clickJSConfirmButton() {
		JSConfirmButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		driver.switchTo().alert();
		String alertText = driver.switchTo().alert().getText();
		alert.accept();
		return alertText;
	}

	public JavaScriptAlertPage clickJSPromptButton(String message) {
		JSPromptButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		alert.sendKeys(message);
		alert.accept();
		return this;
	}

	public String getResults() {
		return result.getText();
	}

	// get url
	public JavaScriptAlertPage getUrl() {
		driver.navigate().to(AbstractE2E.url + "/javascript_alerts");
		return this;
	}
}
