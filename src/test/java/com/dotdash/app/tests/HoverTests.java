package com.dotdash.app.tests;

import com.dotdash.app.pageobjects.HomePage;
import com.dotdash.app.pageobjects.HoverPage;
import com.dotdash.app.pageobjects.LoginPage;
import com.dotdash.core.helpers.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HoverTests extends BaseTest {
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
