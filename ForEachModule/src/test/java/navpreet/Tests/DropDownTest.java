package navpreet.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import navpreet.pageobjects.DropDownPageObject;
import navpreet.util.ObjectsOfClasses;


public class DropDownTest extends ObjectsOfClasses{

	ObjectsOfClasses base_instance;
	DropDownPageObject drop;
	String text;
	
	@Test(description="Test selects Option 1 and Option 2 from the drop down menu.Test asserts Option 1 and Option 2 are selected.")
	public void DropDownMenu() throws IOException {
		
		drop=dropDownApplication();
		drop.ClickDropDown();				
		drop.selectOption1();									//Select 1st drop down
		String selectedOption=drop.isOptionSelected();
		Assert.assertEquals(selectedOption, "Option 1");

		
		drop.selectOption2();									//Select 2nd drop down
		selectedOption=drop.isOptionSelected();
		Assert.assertEquals(selectedOption, "Option 2");
	
	}
}
