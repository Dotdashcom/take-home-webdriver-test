package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDown_page 
{
	WebDriver driver;
	public DropDown_page(WebDriver driver)
	{
		this.driver = driver;
	}
	@FindBy(xpath = "//select[@id='dropdown']")
	WebElement optionDropdown;
	public void select_Option(String option)
	{
		Select selectOption = new Select(optionDropdown);
		selectOption.selectByVisibleText(option);
		
	}
	@FindBy(xpath = "//option[@selected='selected' and contains(text(), 'Please select an option')]")
	public WebElement nullSelection;
	@FindBy(xpath = "//option[@selected='selected' and contains(text(), 'Option 1')]")
	public WebElement option1;
	@FindBy(xpath = "//option[@selected='selected' and contains(text(), 'Option 2')]")
	public WebElement option2;
}
