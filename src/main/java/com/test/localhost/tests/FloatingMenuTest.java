package com.test.localhost.tests;

import com.test.localhost.pages.FloatingMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatingMenuTest extends TestBase {

    @Test
    public void floatingMenuTest(){
        FloatingMenuPage floatingMenuPage=new FloatingMenuPage(driver);
        floatingMenuPage.clickFloatingMenu();
        floatingMenuPage.clickScrollButton(driver);
        Assert.assertTrue(floatingMenuPage.isDisplayedHome());
    }


}
