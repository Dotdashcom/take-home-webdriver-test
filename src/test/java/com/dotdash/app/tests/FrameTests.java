package com.dotdash.app.tests;

import com.dotdash.app.pageobjects.FramePage;
import com.dotdash.app.pageobjects.HomePage;
import com.dotdash.core.helpers.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrameTests extends BaseTest {
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
