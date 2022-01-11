package com.example.demo;

import pages.FloatingMenuPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class T12FloatingMenu extends TestMain{
    FloatingMenuPage floatingMenuPage;

    @Test
    public void testFloatingMenu(){
        floatingMenuPage = new FloatingMenuPage(driver);
        floatingMenuPage.scrollDown();
        Assert.assertTrue(floatingMenuPage.isFloatingMenuStill());
    }
}
