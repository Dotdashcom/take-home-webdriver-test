package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicControlsPage extends BasePage{

	private String page = "dynamic_controls";
	
	private By addRemoveButton = By.cssSelector("#checkbox-example > button");
	private By checkbox = By.id("checkbox");
	private By message = By.id("message");
	private By loading = By.id("loading");
	private By enableDisableButton = By.cssSelector("#input-example > button");
	private By input = By.cssSelector("#input-example > input");

	
	public DynamicControlsPage(WebDriver driver) {
		super(driver);
		setPageUrl(page);
	}

	public void clickAddRemoveButton() {
		driver.findElement(addRemoveButton).click();
	}
	
	public void clickEnableDisableButton() {
		driver.findElement(enableDisableButton).click();
	}
	
	public By getByLoading() {
		return loading;
	}
	
	public By getByMessageField() {
		return message;
	}
	
	public boolean isInputEnable() {
		return driver.findElement(input).isEnabled();
	}
	
	public boolean isCheckboxVisible() {
		try {
			driver.findElement(checkbox).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public String getMessage() {
		return driver.findElement(message).getText();
	}
}
