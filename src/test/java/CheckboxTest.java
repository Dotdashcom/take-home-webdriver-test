import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import configuration.Browser;
import configuration.DriverFactory;
import configuration.PropertyReader;
import module.Checkboxes;

public class CheckboxTest {

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
	
	/**
	 * Check that the checkboxes load with their default values
	 * First checkbox should be unchecked and second one should be checked
	 */
	@Test
	public void checkboxesLoadWithDefaultValues() {
		Checkboxes checkboxPage = new Checkboxes(driver);
		assertTrue("Expected to be unchecked", checkboxPage.isChecked(0) == false);
		assertTrue("Expected to be checked", checkboxPage.isChecked(1) == true);
	}
	
	/**
	 * Check all the checkboxes and ensure they are selected
	 */
	@Test
	public void checkAllCheckBoxes() {
		Checkboxes checkboxPage = new Checkboxes(driver);
		checkboxPage.setCheckbox(0, true);
		checkboxPage.setCheckbox(1, true);
		assertTrue("Expected to be checked", checkboxPage.isChecked(0) == true);
		assertTrue("Expected to be checked", checkboxPage.isChecked(1) == true);		
	}
	
	/**
	 * Uncheck all the checkboxes and ensure they are unselected
	 */	
	@Test
	public void uncheckAllCheckBoxes() {
		Checkboxes checkboxPage = new Checkboxes(driver);
		checkboxPage.setCheckbox(0, false);
		checkboxPage.setCheckbox(1, false);
		assertTrue("Expected to be unchecked", checkboxPage.isChecked(0) == false);
		assertTrue("Expected to be unchecked", checkboxPage.isChecked(1) == false);		
	}
	
	@After
	public void cleanup() {
		driver.quit();
	}

	
}
