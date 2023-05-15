package testCases;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import pageObjectModel.DynamicControlsPage;
import pageObjectModel.HomePage;

public class DynamicControlsTest extends BaseTest {	
	@Test
	public void removeAddButtons() {
		HomePage homePage= new HomePage(driver);
		DynamicControlsPage dynamicControls = homePage.clickDynamicControl();
		assertEquals(dynamicControls.clickRemoveAddButton(), "It's gone!");
		assertEquals(dynamicControls.clickRemoveAddButton(), "It's back!");
	}
	
	@Test
	public void enableThenDisable() {
		HomePage homePage= new HomePage(driver);
		DynamicControlsPage dynamicControls = homePage.clickDynamicControl();
		assertFalse(dynamicControls.checkEnableBox());
		dynamicControls.clickEnableButton();
		assertTrue(dynamicControls.checkEnableBox());
		dynamicControls.clickEnableButton();
		assertFalse(dynamicControls.checkEnableBox());
	
	}
}
