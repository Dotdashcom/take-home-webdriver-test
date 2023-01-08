package tests;

import model.MouseHoverPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class MouseHoverTest extends BaseTest {

    @Test
    public void testFirstImageHover() {
        boolean actualResult = new MouseHoverPage(getDriver())
                .getMouseHoverPage()
                .hoverFirstImage()
                .isFirstImageCaptionDisplayed();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testSecondImageHover() {
        boolean actualResult = new MouseHoverPage(getDriver())
                .getMouseHoverPage()
                .hoverSecondImage()
                .isSecondImageCaptionDisplayed();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testThirdImageHover() {
        boolean actualResult = new MouseHoverPage(getDriver())
                .getMouseHoverPage()
                .hoverThirdImage()
                .isThirdImageCaptionDisplayed();

        Assert.assertTrue(actualResult);
    }
}