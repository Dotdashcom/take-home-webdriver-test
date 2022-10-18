package com.dotdash.testcases;

import com.dotdash.pageObject.SwitchToFrameAndWindowPage;
import com.framework.libraries.MyTestClasses;
import org.testng.annotations.Test;

public class SwitchToFrameAndWindow extends Setup{
    SwitchToFrameAndWindowPage switchToFrameAndWindowPage;

    public SwitchToFrameAndWindow() {
        this.switchToFrameAndWindowPage = MyTestClasses.getObject(SwitchToFrameAndWindowPage.class);
    }

    @Test(testName = "validate switching to frame and enter text")
    public void validateTextInputInFrame(){
        navigateTo("iframe");
        switchToFrameAndWindowPage.switchToFrame();
        switchToFrameAndWindowPage.enterTextInFrame("switching frame test");
        switchToFrameAndWindowPage.assertTextInputInFrame("switching frame test");
    }

    @Test(testName = "Validate new tab is opened")
    public void validateNewTabOpened(){
        navigateTo("windows");
        switchToFrameAndWindowPage.openNewTab();
        switchToFrameAndWindowPage.assertNewTabOpened("New Window");
    }
}
