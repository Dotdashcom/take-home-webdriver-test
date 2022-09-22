package com.mitt.test;

import com.mitt.pages.FileDownloadPage;
import com.mitt.pages.IFramePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IFrameTests extends BaseTest{

    IFramePage iframePage;

    @BeforeClass
    public void setUp(){
        iframePage = new IFramePage(getDriver(), getWait());
    }

    @Test
    public void testRightClickContextMenu() throws InterruptedException {
        iframePage.iframeVerification();
    }
}
