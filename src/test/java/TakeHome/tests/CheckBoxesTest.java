package TakeHome.tests;

import TakeHome.pages.CheckboxesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxesTest extends TestBase {
    CheckboxesPage checkboxesPage = new CheckboxesPage();

    @Test (groups = {"Checkbox"})
    public void checkAndUncheckBoxesTest() {
        checkboxesPage.clickCheckBoxes();

        // to start w a clean slate, uncheck all checkboxes and verify unselected
        int checkboxInd = 1;
        for (WebElement checkbox : checkboxesPage.checkBoxes) {
            if (checkbox.isEnabled() && checkbox.isSelected()) {
                checkbox.click();
                Assert.assertFalse(checkbox.isSelected(), "Checkbox"  + checkbox + " should have been unselected but is not");
            }
        }

        // w all checkboxes unchecked, check them all to verify full functionality
        int index = 1;
        for (WebElement checkbox : checkboxesPage.checkBoxes) {
                checkbox.click();
                Assert.assertTrue(checkbox.isSelected(), "Checkbox"  + index + " should have been selected but is not");
            index ++;
        }
    }
}

