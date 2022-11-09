package com.dotdash.selenium;

import com.dotdash.selenium.pages.HomePage;
import com.dotdash.selenium.pages.HoverPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HoverTests extends SetUpTearDown {
    HomePage homePage;
    HoverPage hoverPage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        hoverPage = new HoverPage(driver);
    }

    @Test
    public void verifyCaptionImage1(){
        homePage.clickHoversLink();
        hoverPage.hoverImage(0);
        Assert.assertEquals("name: user1", hoverPage.getCaption(0));
    }

    @Test
    public void verifyCaptionImage2(){
        homePage.clickHoversLink();
        hoverPage.hoverImage(1);
        Assert.assertEquals("name: user2", hoverPage.getCaption(1));
    }

    @Test
    public void verifyCaptionImage3(){
        homePage.clickHoversLink();
        hoverPage.hoverImage(2);
        Assert.assertEquals("name: user3", hoverPage.getCaption(2));
    }
}
