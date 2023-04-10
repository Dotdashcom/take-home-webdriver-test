package navpreet.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import navpreet.pageobjects.DynamicControlsPageObject;
import navpreet.util.ObjectsOfClasses;

public class DynamicControlsTest extends ObjectsOfClasses {

	WebDriver driver;
	DynamicControlsPageObject dcpo;
	ObjectsOfClasses base_instance;
	String text;
	
	@Test(priority=1,description="Test clicks on the Remove Button and uses explicit wait.")
	public void Check_Checkbox_Gone() throws IOException
	{
		dcpo=dynamicControlsApplication();
		dcpo.ClickDynamicControls();
		text=dcpo.removeCheckbox();
		Assert.assertEquals(text,"It's gone!");
	}
	
	@Test(priority=2,description="Test asserts that the checkbox is gone.")
	public void Check_CheckBox_Back() throws IOException
	{
		dcpo=dynamicControlsApplication();
		dcpo.ClickDynamicControls();
		dcpo.removeCheckbox();
		text=dcpo.addCheckbox();
		Assert.assertEquals(text,"It's back!");
	}
	
	@Test(description="Test clicks on the Enable Button and uses explicit wait.Test asserts that the text box is enabled.")
	public void Click_EnableButton() throws IOException
	{
		dcpo=dynamicControlsApplication();
		dcpo.ClickDynamicControls();
		text=dcpo.enableTextBox();
		Assert.assertEquals(text,"It's enabled!");
	}
	
	@Test(dependsOnMethods= {"Click_EnableButton"},description="Test clicks on the Disable Button and uses explicit wait.Test asserts that the text box is disabled.")
	public void Click_DisableButton() throws IOException
	{
		dcpo=dynamicControlsApplication();
		dcpo.ClickDynamicControls();
		dcpo.enableTextBox();
		text=dcpo.disableTextBox();
		Assert.assertEquals(text,"It's disabled!");
	}
}
