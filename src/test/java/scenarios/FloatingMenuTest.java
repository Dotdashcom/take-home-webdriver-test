package scenarios;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.FloatingMenuPage;


public class FloatingMenuTest extends BaseTest {
    private FloatingMenuPage floatingMenuPage;

    @BeforeMethod
    public void setup() {
        floatingMenuPage = homePage.gotoFloatingMenuPage();
    }

    @Test
    public void floatingMenuDisplayedScrollPageToBottomTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(floatingMenuPage.isFloatingMenuPresent(), "Floating menu should be displayed!");

        floatingMenuPage.scrollToBottom();
        softAssert.assertTrue(floatingMenuPage.isFloatingMenuPresent(), "Floating menu should still be displayed even after scroll!");

        softAssert.assertAll();
    }
}