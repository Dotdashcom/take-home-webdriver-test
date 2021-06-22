import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.DynamicControls;

public class DynamicControlsTest {

	private WebDriver driver = null;
	
	@Before
	public void init() {
		// TODO:  Move to common place
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
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
		assertTrue(dynamicControlsPage.isCheckboxPresent(false));
			
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
		assertTrue(dynamicControlsPage.isCheckboxPresent(true));
		
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
		assertTrue(dynamicControlsPage.isTextFieldEnabled(true));
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
		assertTrue(dynamicControlsPage.isTextFieldEnabled(false));
	}		
	
	@After
	public void cleanup() {
		driver.quit();
	}
	
}
