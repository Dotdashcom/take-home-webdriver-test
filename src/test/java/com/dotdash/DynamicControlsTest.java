package com.dotdash;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicControlsTest extends Util{

    protected DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setUp(){
        driver = getDriver();
        dynamicControlsPage = PageFactory.initElements(driver, DynamicControlsPage.class);
    }
    
    @Test
    public void test_Add_Remove_Button(){
        dynamicControlsPage.addRemoveButton();
    }
    
    @Test
    public void test_Enable_Disable_Button(){
        dynamicControlsPage.enableTextField();
    }

    @AfterMethod
    public void endTest(){
        teardown();
    }

}