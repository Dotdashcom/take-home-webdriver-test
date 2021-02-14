package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BaseDriver {
	
	public DropdownPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id ="dropdown")
    public WebElement dropdownList;
	
	public String selectDropdownOption(String optionText) {
		Select dropdown = new Select(dropdownList);
		dropdown.selectByVisibleText(optionText);
		return dropdown.getFirstSelectedOption().getText();
	}
}
