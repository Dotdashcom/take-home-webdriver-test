package com.dotdash.test;

import com.dotdash.testBase.TestBase;
import com.dotdash.utils.BrowserFactory;
import com.dotdash.utils.CommonMethods;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenu extends TestBase {

    @Test(testName = "Right click on page")
    public void clickOnContext(){
        CommonMethods.navigateTo("context_menu");
        Actions actions = new Actions(BrowserFactory.getDriver());
        actions.contextClick(contextMenuPage.hotSpot).release().perform();
        Assert.assertEquals("You selected a context menu",CommonMethods.switchToAlert().getText());
    }
}
