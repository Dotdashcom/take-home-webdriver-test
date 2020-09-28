import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import base.WebLink;
import pages.OpenNewTabPage;

public class OpenNewTab_Test extends BaseTest {
	OpenNewTabPage page = null;

	@Test
	public void validateOptionOne() {
		try {
			page = new OpenNewTabPage(driver);
			driver.get(WebLink.openNewTabPageUrl);
			page.clickOpenNewTab();
			Assert.assertEquals(page.hasNewWindowOpened(), true);
		} catch (Exception e) {
			e.getLocalizedMessage();
			Assert.assertTrue(false);
		}
	}

}
