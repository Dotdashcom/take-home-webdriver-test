package com.dotdash.webtest;

import com.dotdash.webtest.pages.*;
import com.dotdash.webtest.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DotDashTests extends TestBase {

    @Test (priority = 1)
    public void positiveLoginTest() {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);
        formAuthenticationPage.goToFormAuthenticationPage();
        formAuthenticationPage.login(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));
        Assert.assertEquals(formAuthenticationPage.getSuggestionMessage(), "Welcome to the Secure Area. When you are done click logout below.");
        formAuthenticationPage.clickLogout();
    }

    @Test(priority = 2, dataProvider = "loginData")
    public void negativeLoginTest(String username, String password, String message) {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);
        formAuthenticationPage.goToFormAuthenticationPage();
        formAuthenticationPage.login(username, password);
        Assert.assertTrue(formAuthenticationPage.getErrorMessage().contains(message));
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"pal", "SuperSecretPassword!", "Your username is invalid!"},
                {"tomsmith", "007", "Your password is invalid!"}
        };
    }

    @Test(priority = 3)
    public void checkBoxesTest() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.goToCheckboxPage();
        checkboxesPage.clickCheckbox1();
        Assert.assertTrue(checkboxesPage.isCheckbox1Selected());
        checkboxesPage.clickCheckbox2();
        Assert.assertFalse(checkboxesPage.isCheckbox2Selected());
    }

    @Test(priority = 4)
    public void contextMenuTest() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.goToContextMenuPage();
        contextMenuPage.rightClickTest();
        Assert.assertEquals("You selected a context menu", contextMenuPage.getAlertText());
    }

    @Test(priority = 5)
    public void dragAndDropTest() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.goToDragAndDropPage();
        dragAndDropPage.dragAndDrop();
        Assert.assertEquals("A", dragAndDropPage.getTextBoxA());
    }

    @Test(priority = 6)
    public void dropDownTest() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.goToDropDownPage();
        dropdownPage.chooseOption1();
        Assert.assertEquals(dropdownPage.getOptionText(), "Option 1");
        dropdownPage.chooseOption2();
        Assert.assertEquals(dropdownPage.getOptionText(), "Option 2");
    }
}
