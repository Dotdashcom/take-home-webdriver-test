package com.dotdash.tests;

import com.dotdash.base.TestBase;
import com.dotdash.pages.IframePage;

import com.dotdash.utilities.DriverUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Test_13_Iframe extends TestBase {

    @Test
    public void iframe_test() {

        IframePage iframePage = new IframePage();
        iframePage.navigatePages("Frames");
        iframePage.iframeLink.click();
        DriverUtils.getDriver().switchTo().frame(iframePage.iframe);
        iframePage.getIframeBody.clear();
        iframePage.getIframeBody.sendKeys("Hello World!");

        Assertions.assertEquals("Hello World!", iframePage.getIframeBody.getText());

    }
}
