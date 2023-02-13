package com.dotdash.webtest;

import com.dotdash.webtest.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DotDashTests extends TestBase {

    @Test(priority = 1)
    public void checkBoxesTest() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.goToCheckboxPage();
        checkboxesPage.clickCheckbox1();
        Assert.assertTrue(checkboxesPage.isCheckbox1Selected());
        checkboxesPage.clickCheckbox2();
        Assert.assertFalse(checkboxesPage.isCheckbox2Selected());
    }

    @Test(priority = 2)
    public void contextMenuTest() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.goToContextMenuPage();
        contextMenuPage.rightClickTest();
        Assert.assertEquals("You selected a context menu", contextMenuPage.getAlertText());
    }
}
