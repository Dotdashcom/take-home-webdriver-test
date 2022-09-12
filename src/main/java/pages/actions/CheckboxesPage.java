package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import base.Page;
import pages.locators.AllLocators;
import pages.locators.LoginPageLocators;

public class CheckboxesPage extends Page{
	
	
	public void checkCheckbox1() {
		click(locators.checkbox1);
	}
	
	public void checkCheckbox2() {
		click(locators.checkbox2);
	}
	
	public void verifyCheckbox1IsSelected() {
		Assert.assertEquals(true, locators.checkbox1.isSelected());
		System.out.println("Checkbox1 is selected - Assert Passed");
	}
	
	public void verifyCheckbox2IsSelected() {
		Assert.assertEquals(true, locators.checkbox2.isSelected());
		System.out.println("Checkbox2 is selected - Assert Passed");
	}
	

}
