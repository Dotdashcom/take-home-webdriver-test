package com.dotdash.selenium;

import com.dotdash.selenium.pages.CheckBoxPage;
import com.dotdash.selenium.pages.HomePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckBoxTests extends SetUpTearDown {
    HomePage homePage;
    CheckBoxPage checkboxPage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        checkboxPage = new CheckBoxPage(driver);
    }

    @Test
    public void verifyCheckbox1IsChecked(){
        homePage.clickCheckboxesLink();
        checkboxPage.clickCheckbox1();
        Assert.assertTrue(checkboxPage.isCheckbox1Selected());
    }

    @Test
    public void verifyCheckbox2IsUnchecked(){
        homePage.clickCheckboxesLink();
        checkboxPage.clickCheckbox2();
        Assert.assertFalse(checkboxPage.isCheckbox2Selected());
    }
}