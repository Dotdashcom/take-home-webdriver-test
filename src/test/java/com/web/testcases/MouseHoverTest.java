package com.web.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.MouseHoverPage;


public class MouseHoverTest extends TestBase{

    MouseHoverPage mouseHoverPage;

    public MouseHoverTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        driver.get("http://localhost:7080/hovers");
        mouseHoverPage = new MouseHoverPage();
    }


    @Test()
    public void verifyMouseHoverTextDisplay() {
        Actions action = new Actions(driver);

        action.moveToElement(mouseHoverPage.getImg1Hover()).perform();
        Assert.assertFalse(mouseHoverPage.getImg1Text().isEmpty());

        action.moveToElement(mouseHoverPage.getImg2Hover()).perform();
        Assert.assertFalse(mouseHoverPage.getImg2Text().isEmpty());

        action.moveToElement(mouseHoverPage.getImg3Hover()).perform();
        Assert.assertFalse(mouseHoverPage.getImg3Text().isEmpty());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}