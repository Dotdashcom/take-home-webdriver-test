package PageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Browser.BrowserUtilities;
import TestBase.BaseTest;

public class DropDownPage extends BrowserUtilities {
	public DropDownPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "dropdown")
	WebElement dropDownList;
	
	public void getUrl() {
		driver.get(BaseTest.getURL("dropdown"));
	}
	public void selectOption1() {
		boolean firstValue = fnSelectValueFromDropdown("Option 1",dropDownList);
		assertTrue(firstValue);
	}
	public void selectOption2() {
		boolean secondValue = fnSelectValueFromDropdown("Option 2",dropDownList);
		assertTrue(secondValue);
	}
}
