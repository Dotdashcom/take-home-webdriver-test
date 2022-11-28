package com.dotdash.selenium;

import com.dotdash.selenium.pages.FramePage;
import com.dotdash.selenium.pages.HomePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrameTests extends SetUpTearDown {
    HomePage homePage;
    FramePage framePage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        framePage = new FramePage(driver);
    }

    @Test
    public void verifyTypedTextInIframe(){
        String text = "This text is entered into an iframe";
        homePage.clickFramesLink();
        framePage.clickIframeLink();
        framePage.typeInEditor(text);
        Assert.assertEquals(text, framePage.getEditorText());
    }
}
