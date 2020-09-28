import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.DynamicLoadingPage;

public class Dynamic_Loading_Test extends BaseTest {
	DynamicLoadingPage page = null;

	@Test
	public void validateDynamicLoading() {
		page = new DynamicLoadingPage(driver);
		try {
			Assert.assertTrue(page.verifyTextElement());
		} catch (Exception e) {
			e.getLocalizedMessage();
			Assert.assertTrue(false);
		}
	}
}
