import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import configuration.Browser;
import configuration.DriverFactory;
import configuration.PropertyReader;
import module.DynamicControls;

public class DynamicControlsTest {

	private WebDriver driver = null;
	
	@Before
	public void init() throws IOException {
		Browser browser = Browser.valueOf(
				PropertyReader.getPropertiesFromFile(
						"src/test/resources/config.properties",
						"browser"));
		
		driver = DriverFactory.getDriver(browser);
		driver.manage().window().maximize();		
	}
	
	/*
	 * Click the button to remove the checkbox
	 */
	@Test
	public void removeCheckbox() {
		
		DynamicControls dynamicControlsPage = new DynamicControls(driver);
		
		dynamicControlsPage.clickRemoveCheckboxButton();
		System.out.println("Got message: " + dynamicControlsPage.getMessage());
		String message = dynamicControlsPage.getMessage();
		
		assertTrue(message.equals("It's gone!"));
		assertTrue("Checkbox was still present", dynamicControlsPage.isCheckboxPresent(false));
			
	}
	
	
	/*
	 * Removes checkbox, then click button to confirm it can be added back
	 */
	@Test
	public void addCheckbox() {
		
		DynamicControls dynamicControlsPage = new DynamicControls(driver);
		
		dynamicControlsPage.clickRemoveCheckboxButton();	
		dynamicControlsPage.clickAddCheckboxButton();
		System.out.println("Got message: " + dynamicControlsPage.getMessage());
		String message = dynamicControlsPage.getMessage();
		
		assertTrue(message.equals("It's back!"));
		assertTrue("Checkbox did not appear", dynamicControlsPage.isCheckboxPresent(true));
		
	}
	
	/*
	 * Click the button to enable the textfield
	 */
	@Test
	public void enableTextfield() {
		
		DynamicControls dynamicControlsPage = new DynamicControls(driver);
		
		dynamicControlsPage.clickEnableButton();			
		System.out.println("Got message: " + dynamicControlsPage.getMessage());
		String message = dynamicControlsPage.getMessage();
		
		assertTrue(message.equals("It's enabled!"));
		assertTrue("Field was still disabled", dynamicControlsPage.isTextFieldEnabled(true));
	}
	
	/*
	 * Enable the textfield, then click the button the confirm it can be disabled
	 */
	@Test
	public void disableTextfield() {
		
		DynamicControls dynamicControlsPage = new DynamicControls(driver);
		
		dynamicControlsPage.clickEnableButton();
		dynamicControlsPage.clickDisableButton();
		System.out.println("Got message: " + dynamicControlsPage.getMessage());
		String message = dynamicControlsPage.getMessage();
		
		assertTrue(message.equals("It's disabled!"));
		assertTrue("Field was still enabled", dynamicControlsPage.isTextFieldEnabled(false));
	}		
	
	@After
	public void cleanup() {
		driver.quit();
	}
	
}
