package com.dotdash.selenium;

import com.dotdash.selenium.pages.DropDownPage;
import com.dotdash.selenium.pages.HomePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DropDownTests extends SetUpTearDown {
    HomePage homePage;
    DropDownPage dropdownPage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        dropdownPage = new DropDownPage(driver);
    }

    @Test
    public void verifyDropdownOption1IsSelected(){
        homePage.clickDropdownLink();
        dropdownPage.selectDropdownOptionByText("Option 1");
        Assert.assertEquals("Option 1", dropdownPage.getSelectedDropdownOption());

    }

    @Test
    public void verifyDropdownOption2IsSelected(){
        homePage.clickDropdownLink();
        dropdownPage.selectDropdownOptionByText("Option 2");
        Assert.assertEquals("Option 2", dropdownPage.getSelectedDropdownOption());

    }
}
