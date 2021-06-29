import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import configuration.Browser;
import configuration.DriverFactory;
import configuration.PropertyReader;
import module.Dropdown;

public class DropDownTest {

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
	
	@Test
	public void selectOption1() {
		Dropdown dropdownPage = new Dropdown(driver);
		dropdownPage.selectOption("Option 1");
		assertTrue("Unexpected option was selected", dropdownPage.getSelectedValue().equals("Option 1"));		
	}
	
	@Test
	public void selectOption2() {
		Dropdown dropdownPage = new Dropdown(driver);
		dropdownPage.selectOption("Option 2");
		assertTrue("Unexpected option was selected", dropdownPage.getSelectedValue().equals("Option 2"));		
	}
	
	@After
	public void cleanup() {
		driver.quit();
	}

	
}
