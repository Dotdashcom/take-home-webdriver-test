package org.example;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FloatingMenuTest extends BasePage{

    protected FloatingMenuPage floatingMenuPage;

    @BeforeClass
    public void setUp(){
        driver = getDriver();
        floatingMenuPage = PageFactory.initElements(driver, FloatingMenuPage.class);
    }

    @Test
    public void testFloatingMenu(){
        floatingMenuPage.scrollPage();
        Assert.assertTrue(floatingMenuPage.getHomeIcon().isDisplayed());
        Assert.assertTrue(floatingMenuPage.getContactIcon().isDisplayed());
    }

    @AfterMethod
    public void endTest(){
        teardown();
    }
}
