package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testbase.TestBase;

public class DropDownPage {

	WebDriver driver;

	public DropDownPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elements or locators
	@FindBy(id = "dropdown")
	WebElement dropDown;
	
	private Select dropdownSelect;

	public String getSelectedOption() {
		dropdownSelect = new Select(dropDown);
		return dropdownSelect.getAllSelectedOptions().get(0).getText();
	}

	public void selectOptionByVisibleText(String text) {
		dropdownSelect.selectByVisibleText(text);
	}

	// get url
	public DropDownPage getUrl() {
		driver.navigate().to(TestBase.url + "/dropdown");
		return this;
	}

}
