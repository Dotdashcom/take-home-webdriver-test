package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractClass;

public class DynamicControlsPage extends AbstractClass {
	WebDriver driver;
	@FindBy(css = "button[onclick='swapCheckbox()']")
	WebElement swapcheckbox;
	@FindBy(id = "checkbox")
	WebElement checkbox;
	@FindBy(css = "button[onclick='swapInput()']")
	WebElement enable;
	@FindBy(css = "input[type='text']")
	WebElement textBox;
	@FindBy(id = "message")
	WebElement dismsg;
	By checkboxby = By.id("checkbox");
	By enableby = By.cssSelector("input[type='text']");
	By idby = By.id("message");

	public DynamicControlsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean checkboxdissapear() {
		swapcheckbox.click();
		waitforElementToAppear(checkboxby);
		return checkbox.isDisplayed();
	}

	public boolean checkboxappear() {
		swapcheckbox.click();
		waitforElementToAppear(checkboxby);
		return checkbox.isDisplayed();
	}

	public boolean textBoxenable() {
		enable.click();
		waitforElementTobeclikable(enableby);
		return textBox.isEnabled();
	}

	public String textBoxdisabled() {
		enable.click();
		waitforElementToAppear(idby);
		String displaymessage = dismsg.getText();
		return displaymessage;

	}

}
