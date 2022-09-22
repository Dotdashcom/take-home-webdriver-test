package com.mitt.test;

import com.mitt.pages.DynamicContentPage;
import com.mitt.pages.DynamicControlPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicControlTests extends  BaseTest{

    DynamicControlPage dynamicControlPage;

    @BeforeClass
    public void setUp(){
        dynamicControlPage = new DynamicControlPage(getDriver(), getWait());
    }

    @Test(priority = 1)
    public void testRemoveButton(){
        dynamicControlPage.validateRemoveButton();
    }

    @Test(priority = 2)
    public void testAddButton(){
        dynamicControlPage.validateAddButton();
    }

    @Test(priority = 3)
    public void testEnableButton(){
        dynamicControlPage.validateEnableButton();
    }

    @Test(priority = 4)
    public void testdisableButton(){
        dynamicControlPage.validateDiableButton();
    }
}
