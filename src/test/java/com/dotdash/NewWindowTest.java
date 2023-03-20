package com.dotdash;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewWindowTest extends Util{

    protected NewWindowPage newWindowPage;

    @BeforeClass
    public void setUp(){
        driver = getDriver();
        newWindowPage = PageFactory.initElements(driver, NewWindowPage.class);
    }

    @Test
    public void new_Window_Test(){
        newWindowPage.NewWindow();
        Assert.assertEquals(newWindowPage.getNewWindowText(),"New Window");
    }

    @AfterMethod
    public void endTest(){
        teardown();
    }
}