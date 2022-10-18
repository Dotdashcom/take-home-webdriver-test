package com.dotdash.pageObject;

import com.framework.libraries.I;
import org.testng.Assert;

public class FloatingMenuPage {
    String floatingMenu="//div[@id='menu']";

    public void moveToText(){
        I.amPerforming().scrollToMiddleViewOfElement(I.amPerforming().getWebElement("//p[3]"));
    }

    public void assertMenuDisplayedAfterScroll(){
        Assert.assertTrue(I.amPerforming().isDisplayed(floatingMenu));
    }
}
