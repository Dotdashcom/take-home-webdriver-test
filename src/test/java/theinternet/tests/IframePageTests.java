package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.IframePage;

public class IframePageTests extends BaseTest{
    IframePage iframePage;
    @BeforeClass
    public void initialize() throws InterruptedException {
        homePage.navigateToIframePage();
        iframePage = new IframePage();
        Thread.sleep(2000);
    }

    @Test(priority = 0)
    public void testIframePageLanding(){
        Assert.assertTrue(iframePage.validatePageLanding(),"iframe testing page not loaded");
    }

    @Test(priority = 0)
    public void testIframeText(){
        String myText = "text text";
        iframePage.typeIntoIframe(myText);
        Assert.assertTrue(iframePage.getTextFromIframe().contains(myText), "Text was not typed in successfully");
    }


}
