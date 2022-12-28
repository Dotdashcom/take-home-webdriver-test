package com.test.localhost.tests;

import com.test.localhost.pages.IframePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTest extends TestBase {

    @Test
    public void FrameTest(){
        IframePage iFramePage=new IframePage(driver);
        iFramePage.clickButtons();
        iFramePage.sendAndGetText(driver);
        iFramePage.notificationMsg(driver);
    Assert.assertEquals(iFramePage.sendAndGetText(driver),"my input message");



    }


}
