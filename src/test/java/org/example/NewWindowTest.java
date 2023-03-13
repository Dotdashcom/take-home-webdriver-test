package org.example;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewWindowTest extends BasePage{

    protected NewWindowPage newWindowPage;

    @BeforeClass
    public void setUp(){
        driver = getDriver();
        newWindowPage = PageFactory.initElements(driver, NewWindowPage.class);
    }

    @Test
    public void newWindowTest(){
        newWindowPage.NewWindow();
        Assert.assertEquals(newWindowPage.getNewWindowText(),"New Window");
    }

    @AfterMethod
    public void endTest(){
        teardown();
    }
}
