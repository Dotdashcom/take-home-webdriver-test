package com.web.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.OpenInNewTabPage;

public class OpenInNewTabTest extends TestBase{

    OpenInNewTabPage openInNewTabPage;

    public OpenInNewTabTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        driver.get("http://localhost:7080/windows");
        openInNewTabPage = new OpenInNewTabPage();
    }


    @Test()
    public void verifyOpenInNewTab()
    {
        openInNewTabPage.getLinkText().click();

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        Assert.assertEquals(driver.getTitle(),"New Window");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
