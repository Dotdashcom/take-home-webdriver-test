package com.dotdash.pageObject;

import com.framework.libraries.I;
import org.testng.Assert;

public class ContextMenuPage {

    public void rightClick(){
        I.amPerforming().mouseActions().contextClick(I.amPerforming().getWebElement("//div[@id='hot-spot']")).release().perform();
    }

    public void assertContextClick(String text){
        System.out.println(I.amPerforming().switchToAlert().getText());
        Assert.assertEquals(text,I.amPerforming().switchToAlert().getText());
    }
}
