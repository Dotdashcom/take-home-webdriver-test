package navpreet.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import navpreet.pageobjects.CheckBoxesPageObject;
import navpreet.util.ObjectsOfClasses;
public class CheckBoxTest extends ObjectsOfClasses{

	ObjectsOfClasses base_instance;
	WebDriver driver;
	CheckBoxesPageObject cbpo;
	
	@Test(description="Test checks and unchecks checkboxes.Test uses assertions to make sure boxes were properly checked and unchecked.")
	public void TestCheckboxes() throws IOException 
	{
		cbpo=checkBoxApplication();
		cbpo.ClickCheckbox();
		cbpo.ChooseCheckboxes();	
	}
}
