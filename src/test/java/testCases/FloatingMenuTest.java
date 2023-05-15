package testCases;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pageObjectModel.FloatingMenuPage;
import pageObjectModel.HomePage;

public class FloatingMenuTest extends BaseTest {
	@Test
	public void floatingMenu() {
		HomePage homePage = new HomePage(driver);
		FloatingMenuPage floatingMenu = homePage.clickFloatMenu();
		assertTrue(floatingMenu.elemDisplayed());
	}
}
