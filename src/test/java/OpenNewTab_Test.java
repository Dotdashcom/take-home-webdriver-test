import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import base.WebLink;
import pages.OpenNewTabPage;

public class OpenNewTab_Test extends BaseTest {
	OpenNewTabPage page = null;

	@Test
	public void openNewTabvalidation() {
		try {
			page = new OpenNewTabPage(driver);
			driver.get(WebLink.openNewTabPageUrl);
			page.clickOpenNewTab();
			Assert.assertEquals(page.hasNewWindowOpened(), true);
		} catch (Exception e) {
			Assert.assertTrue(false);
			e.getLocalizedMessage();
		}
	}

}
