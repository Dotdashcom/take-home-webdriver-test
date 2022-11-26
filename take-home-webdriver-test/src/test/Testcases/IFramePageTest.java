package com.framework.testcases;
import com.framework.pages.IFramePage;
import com.framework.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IFramePageTest extends TestBase {
    IFramePage iFramePage;

    @BeforeTest
    public void setup() {
        super.setup();
    }


    @Test(priority = 1, description = "User is on the iframe page")
    public void user_is_on_iframe_page() {
        iFramePage = new IFramePage(driver);
        iFramePage.navigate();
        String actualURL = iFramePage.getCurrentURL();
        String expectedURL = "http://localhost:7080/iframe";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test(priority = 2, description = "User can switch to iframe")
    public void user_can_switch_to_iframe() throws InterruptedException {
        String TEXT = "New text is here";
        iFramePage = new IFramePage(driver);
        iFramePage.navigate().switchToIframe();
        String expectedText = iFramePage.getText() + TEXT;
        String actualText = iFramePage.sendText(TEXT).getText();
        Assert.assertEquals(actualText, expectedText);
    }
    @AfterTest
    public void teardown() {
        super.cleanup();
    }

}
