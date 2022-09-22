package com.mitt.test;

import com.mitt.pages.DropDownPage;
import com.mitt.pages.DynamicContentPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicContentTests extends BaseTest{

    DynamicContentPage dynamiccontentPage;

    @BeforeClass
    public void setUp(){
        dynamiccontentPage = new DynamicContentPage(getDriver(), getWait());
    }

    @Test
    public void testRightClickContextMenu(){
        dynamiccontentPage.dynamicContentVerification();
    }
}
