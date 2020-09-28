import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import base.WebLink;
import pages.FloatingMenuPage;

public class FloatingMenu_Test extends BaseTest {
	FloatingMenuPage page = null;

	@Test
	public void validateOptionOne() {
		page = new FloatingMenuPage(driver);
		try {
			driver.get(WebLink.floatingMenuPageUrl);
			page.scrollByPixel();

			Assert.assertEquals(page.isMenuDisplayed(), true);
		} catch (Exception e) {
			Assert.assertTrue(false);
			e.getLocalizedMessage();
		}
	}
}
