package com.ddm.testcases;

import com.ddm.pageobjects.MultipleWindowsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsTests extends BaseTestClass {

    protected MultipleWindowsPage multipleWindowsPage;

    @BeforeMethod
    public void setUpMethodMultipleWindows() {
        multipleWindowsPage = landingPage.goTo("/windows", MultipleWindowsPage.class);
    }

    @Test
    public void multipleWindowsTest() {
        multipleWindowsPage.openANewWindow();
        multipleWindowsPage.switchToChildWindow();
        Assert.assertEquals(multipleWindowsPage.getTextInNewWindow(), "New Window");
        multipleWindowsPage.closeChildWindow();
        multipleWindowsPage.switchToParenWindow();
    }
}
