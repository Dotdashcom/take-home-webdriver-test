package com.dotdash.test;

import com.dotdash.testBase.TestBase;
import com.dotdash.utils.CommonMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchToFrameAndWindow extends TestBase {

    @Test(testName = "validate switching to frame and enter text")
    public void validateTextInputInFrame(){
        CommonMethods.navigateTo("iframe");
        CommonMethods.click(switchToFrameAndWindowPage.close);
        CommonMethods.switchTo().frame(switchToFrameAndWindowPage.iframe);
        CommonMethods.clear(switchToFrameAndWindowPage.iframeBody);
        CommonMethods.input(switchToFrameAndWindowPage.iframeBody, "switching frame test");
        Assert.assertEquals(CommonMethods.getText(switchToFrameAndWindowPage.iframeBody), "switching frame test");
    }

    @Test(testName = "Validate new tab is opened")
    public void validateNewTabOpened(){
        CommonMethods.navigateTo("windows");
        CommonMethods.click(switchToFrameAndWindowPage.clickHere);
        String newTab = CommonMethods.getWindowHandles().get(1);
        CommonMethods.switchTo().window(newTab);
        Assert.assertEquals(CommonMethods.getText(switchToFrameAndWindowPage.newWindowValidate), "New Window");
    }
}