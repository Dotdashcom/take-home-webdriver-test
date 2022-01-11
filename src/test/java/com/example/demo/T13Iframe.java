package com.example.demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IframePage;

public class T13Iframe extends TestMain{
    IframePage iframePage;

    @Test
    public void testIframe(){
        iframePage = new IframePage(driver);
        iframePage.closeAlertMessage();
        iframePage.switchToIframe();
        iframePage.typeInTextbox("This is a test message.");
        Assert.assertEquals(iframePage.getContent(),"Your content goes here."+"This is a test message.");
    }

}
