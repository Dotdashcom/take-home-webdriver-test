package com.dotdash.pageObject;

import com.framework.libraries.I;
import org.testng.Assert;

public class JSPage {

    public void clickJsButton(String buttonName){
        I.amPerforming().click(button(buttonName));
    }

    public void assertJsAlert(String text){
        Assert.assertEquals(I.amPerforming().switchToAlert().getText(),text);
        I.amPerforming().switchTo().alert().accept();
    }

    public void assertJsError(String text){
        Assert.assertEquals(I.amPerforming().getText("//p[contains(text(),'This page has a JavaScript error in the onload event.')]").trim(),text);

    }

    private String button(String text){
        return "//button[text()='"+text+"']";
    }
}
