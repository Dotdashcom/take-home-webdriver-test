import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import base.WebLink;
import pages.CheckBoxPage;
import pages.DropDownPage;
import pages.IframePage;

public class Iframe_Test extends BaseTest {
	IframePage page = null;

	@Test
	public void validateOptionOne() {
		page = new IframePage(driver);
		try {
			driver.get(WebLink.iFramePageUrl);
			page.ChangeFrame();
			page.EnterText();
			Assert.assertEquals(page.verifyIframe(), true);
		} catch (Exception e) {
			Assert.assertTrue(false);
			e.getLocalizedMessage();
		}
	}

}
