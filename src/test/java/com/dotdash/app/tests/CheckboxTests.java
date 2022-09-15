package com.dotdash.app.tests;

import com.dotdash.app.pageobjects.CheckboxPage;
import com.dotdash.app.pageobjects.HomePage;
import com.dotdash.core.helpers.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckboxTests extends BaseTest {
    HomePage homePage;
    CheckboxPage checkboxPage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        checkboxPage = new CheckboxPage(driver);
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
