package com.dotdash.pageObject;

import com.framework.libraries.I;
import org.testng.Assert;

public class NotificationPage {

    public void clickToGetMessage(){
        I.amPerforming().click("//a[contains(text(),'Click here')]");
    }

    public void assertMessage(String text) {
        Assert.assertEquals(I.amPerforming().getText("//div[@id='flash']"),text);
    }
}
