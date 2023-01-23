package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractClass;

public class CheckboxPage extends AbstractClass {
	WebDriver driver;

	public CheckboxPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[1]")
	WebElement firstcheckbox;
	@FindBy(xpath = "//input[2]")
	WebElement secondcheckbox;
	@FindBy(xpath = "//input")
	WebElement checkbox;

	public boolean selectcheckbox() {
		firstcheckbox.click();
		secondcheckbox.click();
		return checkbox.isSelected();

	}

	public boolean deselectcheckbox() {
		firstcheckbox.clear();
		secondcheckbox.clear();
		return checkbox.isSelected();

	}
}
