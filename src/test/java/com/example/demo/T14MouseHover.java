package com.example.demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MouseHoverPage;

public class T14MouseHover extends TestMain{
    MouseHoverPage mouseHoverPage;

    @Test
    public void testMouseHover(){
        mouseHoverPage = new MouseHoverPage(driver);
        for (int i=1;i<4;i++){
            mouseHoverPage.MouseHover(i);
            Assert.assertTrue(mouseHoverPage.isDisplayed(i));
        }
    }
}
