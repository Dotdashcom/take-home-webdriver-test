package com.dotdash.app.tests;

import com.dotdash.app.pageobjects.DropdownPage;
import com.dotdash.app.pageobjects.HomePage;
import com.dotdash.core.helpers.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DropdownTests extends BaseTest {
    HomePage homePage;
    DropdownPage dropdownPage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        dropdownPage = new DropdownPage(driver);
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
