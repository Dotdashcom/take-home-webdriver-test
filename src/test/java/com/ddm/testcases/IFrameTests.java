package com.ddm.testcases;

import com.ddm.pageobjects.IFramePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTests extends BaseTestClass {

    protected IFramePage iFramePage;

    @BeforeMethod
    public void setUpMethodIFrames() {
        iFramePage = landingPage.goTo("/iframe", IFramePage.class);
    }

    @Test
    public void iFramePageTest() {
        iFramePage.createNewDocument();
        String message = "Hello there....";
        iFramePage.updateNewDocument(message);
        Assert.assertEquals(iFramePage.getMessageAreaText(), message, "The message is not same.");
    }
}
