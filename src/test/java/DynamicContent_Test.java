import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.DynamicContentPage;

public class DynamicContent_Test extends BaseTest {
	DynamicContentPage page = null;

	@Test
	public void validateContentChange() {
		page = new DynamicContentPage(driver);
		try {
			Assert.assertEquals(page.verifyContentChange(), false);
			// refresh it again
			Assert.assertEquals(page.verifyContentChange(), false);
		} catch (Exception e) {
			e.getLocalizedMessage();
			Assert.assertTrue(false);
		}
	}
}
