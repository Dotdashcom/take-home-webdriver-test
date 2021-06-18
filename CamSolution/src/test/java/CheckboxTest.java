import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Checkboxes;

public class CheckboxTest {

	private WebDriver driver = null;
	
	@Before
	public void init() {
		// TODO:  Move to common place
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	/**
	 * Check that the checkboxes load with their default values
	 * First checkbox should be unchecked and second one should be checked
	 */
	@Test
	public void checkboxesLoadWithDefaultValues() {
		Checkboxes checkboxPage = new Checkboxes(driver);
		assertTrue(checkboxPage.isChecked(0) == false);
		assertTrue(checkboxPage.isChecked(1) == true);
	}
	
	/**
	 * Check all the checkboxes and ensure they are selected
	 */
	@Test
	public void checkAllCheckBoxes() {
		Checkboxes checkboxPage = new Checkboxes(driver);
		checkboxPage.setCheckbox(0, true);
		checkboxPage.setCheckbox(1, true);
		assertTrue(checkboxPage.isChecked(0) == true);
		assertTrue(checkboxPage.isChecked(1) == true);		
	}
	
	/**
	 * Uncheck all the checkboxes and ensure they are unselected
	 */	
	@Test
	public void uncheckAllCheckBoxes() {
		Checkboxes checkboxPage = new Checkboxes(driver);
		checkboxPage.setCheckbox(0, false);
		checkboxPage.setCheckbox(1, false);
		assertTrue(checkboxPage.isChecked(0) == false);
		assertTrue(checkboxPage.isChecked(1) == false);		
	}
	
	@After
	public void cleanup() {
		driver.quit();
	}

	
}
