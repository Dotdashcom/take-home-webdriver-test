package com.dotdash.tests;

import com.dotdash.pages.IframePage;
import com.dotdash.pages.TestBase;
import com.dotdash.utilities.Driver;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class IframeTest extends TestBase {


    @Test
    public void iframeTest() {

        IframePage iframePage = new IframePage();
        iframePage.navigatePages("Frames");
        iframePage.iframeLink.click();
        Driver.getDriver().switchTo().frame(iframePage.iframe);
        iframePage.getIframeBody.clear();
        iframePage.getIframeBody.sendKeys("Hello World!");

        Assertions.assertEquals("Hello World!", iframePage.getIframeBody.getText());

    }
}
