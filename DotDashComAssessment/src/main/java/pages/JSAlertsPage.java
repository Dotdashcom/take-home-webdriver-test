package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class JSAlertsPage extends PageObjectBase{

	public JSAlertsPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public JSAlertsPage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	public JSAlertsPage clickAlertButton() {

		WebElement alertBtn = this.getDriver().findElement(By.xpath("//button[@onclick='jsAlert()']"));
		alertBtn.click();

		return this;
	}

	public JSAlertsPage clickConfirmButton() {

		WebElement confirmBtn = this.getDriver().findElement(By.xpath("//button[@onclick='jsConfirm()']"));
		confirmBtn.click();

		return this;
	}

	public JSAlertsPage clickPromptButton() {

		WebElement promptBtn = this.getDriver().findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		promptBtn.click();

		return this;
	}

	@Override
	protected String getRelativeUrl() {
		return "/javascript_alerts";
	}

}
