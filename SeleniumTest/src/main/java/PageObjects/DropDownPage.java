package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import AbstractComponents.AbstractClass;

public class DropDownPage extends AbstractClass {
	WebDriver driver;
	@FindBy(id = "dropdown")
	WebElement dropdown;

	public DropDownPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String firstdropDown() {
		dropdown.click();
		Select drpdown = new Select(dropdown);
		drpdown.selectByValue("1");
		String firstoption = drpdown.getFirstSelectedOption().getText();
		return firstoption;

	}

	public String seconddropDown() {
		dropdown.click();
		Select drpdown = new Select(dropdown);
		drpdown.selectByValue("2");
		String secondoption = drpdown.getFirstSelectedOption().getText();
		return secondoption;

	}

}
