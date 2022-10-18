package com.dotdash.pageObject;

import com.framework.libraries.I;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SwitchToFrameAndWindowPage {

    public void switchToFrame(){
        I.amPerforming().click("//div[@aria-label='Close']");
        I.amPerforming().switchTo().frame(I.amPerforming().getWebElement("//iframe[@id='mce_0_ifr']"));
        I.amPerforming().clear("//body");
    }

    public void enterTextInFrame(String text){
        I.amPerforming().input("//body",text);
    }

    public void assertTextInputInFrame(String text){
        Assert.assertEquals(I.amPerforming().getText("//body"),text);
    }

    public void openNewTab(){
        I.amPerforming().click("//a[text()='Click Here']");
        String newTab=I.amPerforming().getWindowHandles().get(1);
        I.amPerforming().switchTo().window(newTab);
    }

    public void assertNewTabOpened(String text){
        Assert.assertEquals(I.amPerforming().getText("//h3[text()='"+text+"']"),text);
    }
}
