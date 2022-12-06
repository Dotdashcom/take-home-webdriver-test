package com.web.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.IframePage;

public class IframeTest extends TestBase{

    IframePage iframePage;

    public IframeTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        driver.get("http://localhost:7080/iframe");
        iframePage = new IframePage();
    }

    @Test()
    public void verifyIframeText(){
        driver.switchTo().frame(iframePage.switchToIframe());
        iframePage.validateSendText();
        Assert.assertEquals(iframePage.validateNewIframeText(),"validation!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
