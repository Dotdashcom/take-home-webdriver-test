import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Dropdown;

public class DropDownTest {

	private WebDriver driver = null;
	
	@Before
	public void init() {
		// TODO:  Move to common place
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void selectOption1() {
		Dropdown dropdownPage = new Dropdown(driver);
		dropdownPage.selectOption("Option 1");
		assertTrue(dropdownPage.getSelectedValue().equals("Option 1"));		
	}
	
	@Test
	public void selectOption2() {
		Dropdown dropdownPage = new Dropdown(driver);
		dropdownPage.selectOption("Option 2");
		assertTrue(dropdownPage.getSelectedValue().equals("Option 2"));		
	}
	
	@After
	public void cleanup() {
		driver.quit();
	}

	
}
