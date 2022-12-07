package TestCases;
import org.testng.annotations.Test;
import Common.Config;
import Common.TestBase;
import Common.TestData;
import Helpers.MouseHoverHelper;
public class TestMouseHover extends TestBase {
	@TestData ({"1", "2", "3"})
	@Test (description = "Test mouse hover", dataProvider = "GetTestData")
	public void testMouseHover(Config testConfig, String imageText) {
		MouseHoverHelper mouseHoverHelper = new MouseHoverHelper(testConfig);
		mouseHoverHelper.hoverOver(imageText);
		mouseHoverHelper.verifyTextIsDisplayed("name: user" + imageText + "\nView profile");
	}
}
