package com.dotdash;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseHoverTest extends Util{

    protected MouseHoverPage mouseHoverPage;

    @BeforeClass
    public void setUp(){
        driver = getDriver();
        mouseHoverPage = PageFactory.initElements(driver, MouseHoverPage.class);
    }
    @Test
    public void mouse_Hover_Test() {
        mouseHoverPage.hoverOverToImage();
    }

    @AfterMethod
    public void endTest(){
        teardown();
    }
}