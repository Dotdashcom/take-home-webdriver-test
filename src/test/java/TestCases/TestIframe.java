package TestCases;
import org.testng.annotations.Test;
import Common.Config;
import Common.TestBase;
import Common.TestData;
import Helpers.IframeHelper;
public class TestIframe extends TestBase {
	@TestData ({"abcdefghijklmnopqrstuvwxyz", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "1234567890", "`!@#$%^&*()_+-=[]\\{}|;':,./\"~"})
	@Test (description = "Test iframe", dataProvider = "GetTestData")
	public void testIframe(Config testConfig, String text) {
		IframeHelper iframeHelper = new IframeHelper(testConfig);
		iframeHelper.addText(text);
		iframeHelper.verifyAddedText(text);
	}
}
