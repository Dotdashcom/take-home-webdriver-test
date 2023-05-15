package testCases;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pageObjectModel.HomePage;
import pageObjectModel.OpeningNewTabPage;

public class OpeningNewTabTest extends BaseTest {
	@Test
	public void opinNewTab() {
		HomePage homePage = new HomePage(driver);
		OpeningNewTabPage newTabs = homePage.clickOpenNewTab();
		assertEquals(newTabs.openTabs(), "New Window");
	}
}
