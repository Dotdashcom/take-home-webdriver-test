package scenarios;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.IframePage;

public class IframeTest extends BaseTest {
    private IframePage iframePage;

    @BeforeMethod
    public void setup() {
        iframePage = homePage.gotoIframePage();
    }

    @Test
    public void enterTextIntoIframeContentTest() {
        String text = "An iFrame containing the TinyMCE WYSIWYG Editor";

        String contentText = iframePage.clickCloseButton()
                .switchToFrame()
                .enterContent(text)
                .getContentText();

        Assert.assertEquals(contentText, text + "Your content goes here.", "Content doesn't match!");
    }
}