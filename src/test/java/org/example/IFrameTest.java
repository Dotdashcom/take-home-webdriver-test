package org.example;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IFrameTest extends BasePage{

    protected IFramePage iFramePage;

    @BeforeClass
    public void setUp(){
        driver = getDriver();
        iFramePage = PageFactory.initElements(driver, IFramePage.class);
    }

    @Test
    public void iFrameTest(){
        iFramePage.iFrameText();
        Assert.assertEquals(iFramePage.getTextBoxInFrame().getText(),"Text is sent");
    }

    @AfterClass
    public void endTest(){
        teardown();
    }
}
