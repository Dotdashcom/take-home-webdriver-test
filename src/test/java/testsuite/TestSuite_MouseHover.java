package testsuite;

import actions.ActionHelper;
import base.BaseTestClass;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.MouseHoverPage;

public class TestSuite_MouseHover extends BaseTestClass {

    MouseHoverPage mouseHoverPage = MouseHoverPage.getInstance();

    @BeforeClass
    public void beforeClass() {
        ActionHelper.openUrl(Constants.HOVERS_PAGE_URL);
    }

    @Test
    public void TC_MouseHover_001_Validate_TextAppearOnHoverImage1Test() {
        mouseHoverPage.mouseHoverFirstImage();
        Assert.assertTrue(mouseHoverPage.firstHeaderIsDisplayed());
    }

    @Test
    public void TC_MouseHover_002_Validate_TextAppearOnHoverImage2Test() {
        mouseHoverPage.mouseHoverSecondImage();
        Assert.assertTrue(mouseHoverPage.secondHeaderIsDisplayed());
    }

    @Test
    public void TC_MouseHover_003_Validate_TextAppearOnHoverImage3Test() {
        mouseHoverPage.mouseHoverThirdImage();
        Assert.assertTrue(mouseHoverPage.thirdHeaderIsDisplayed());
    }
}
