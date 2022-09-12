package pages.actions;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.Page;

public class DropdownPage extends Page {

	public void selectOption(String byText) {
		select(locators.dropdown, byText );
	}
	
	public String getSelected() {
		return new Select(locators.dropdown).getFirstSelectedOption().getText().trim();
	}
	
	public void iSeeInDropdown(String option) {
		String selectedOption = new DropdownPage().getSelected();
		Assert.assertEquals(option, selectedOption);
		System.out.println(selectedOption+ " is selected - Assert Passed");
	}
	
	
}
