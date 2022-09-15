package com.dotdash.app.tests;

import com.dotdash.app.pageobjects.DynamicControlsPage;
import com.dotdash.app.pageobjects.HomePage;
import com.dotdash.core.helpers.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DynamicControlsTests extends BaseTest {
    HomePage homePage;
    DynamicControlsPage dynamicControlsPage;

    @Before
    public void init(){
        homePage = new HomePage(driver);
        dynamicControlsPage = new DynamicControlsPage(driver);
    }

    @Test
    public void verifyCheckboxIsRemoved(){
        homePage.clickDynamicControlsLink();
        dynamicControlsPage.removeCheckbox();
        Assert.assertEquals("It's gone!", dynamicControlsPage.getMessage());
        Assert.assertFalse(dynamicControlsPage.isCheckboxPresent());
    }

    @Test
    public void verifyCheckboxIsAdded(){
        homePage.clickDynamicControlsLink();
        dynamicControlsPage.removeCheckbox();
        dynamicControlsPage.addCheckbox();
        Assert.assertEquals("It's back!", dynamicControlsPage.getMessage());
        Assert.assertTrue(dynamicControlsPage.isCheckboxPresent());
    }

    @Test
    public void verifyTextInputIsEnabled(){
        homePage.clickDynamicControlsLink();
        dynamicControlsPage.enableTextInput();
        Assert.assertEquals("It's enabled!", dynamicControlsPage.getMessage());
        Assert.assertTrue(dynamicControlsPage.isTextInputEnabled());
    }

    @Test
    public void verifyTextInputIsDisabled(){
        homePage.clickDynamicControlsLink();
        dynamicControlsPage.enableTextInput();
        dynamicControlsPage.disableTextInput();
        Assert.assertEquals("It's disabled!", dynamicControlsPage.getMessage());
        Assert.assertFalse(dynamicControlsPage.isTextInputEnabled());
    }
}
