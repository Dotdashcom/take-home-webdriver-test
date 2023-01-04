package scenarios;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.MouseHoverPage;

import java.util.List;

public class MouseHoverTest extends BaseTest {
    private MouseHoverPage mouseHoverPage;

    @BeforeMethod
    public void setup() {
        mouseHoverPage = homePage.gotoMouseHoverPage();
    }

    @Test
    public void mouseHoverDisplaysInfoTest() {
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> images = mouseHoverPage.getImages();

        int index = 1;
        for(WebElement image : images) {
            mouseHoverPage.hoverImage(image);
            softAssert.assertTrue(mouseHoverPage.isHeaderDisplayed(index), "Header " + index + " should be displayed!");
            softAssert.assertTrue(mouseHoverPage.isLinkDisplayed(index), "Link text " + index + " should be displayed!");
            index++;
        }

        softAssert.assertAll();
    }
}