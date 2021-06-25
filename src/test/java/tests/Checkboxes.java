package tests;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.EndPoints;

import java.util.List;

public class Checkboxes extends TestBase {

    @Test
    public void testCheckboxes() {
        CheckBoxPage cb = new CheckBoxPage();
        extentTest = extentReports.createTest("Checkboxes");
        extentTest.info("Navigate To Checkbox Page");
        cb.navigateTo(EndPoints.CHECKBOXES);

        int index = 1;
        for (WebElement checkbox : cb.checkboxes) {
            if (checkbox.isEnabled() && !checkbox.isSelected()) {
                checkbox.click();
                extentTest.info("Checkbox #" + index + " was not clicked");
                Assert.assertTrue(checkbox.isSelected());
                extentTest.info("Checkbox " + index + " is selected");
            } else {
                checkbox.click();
                extentTest.info("Checkbox #" + index + " was clicked");
                Assert.assertFalse(checkbox.isSelected());
                extentTest.info("Checkbox " + index + " is un-selected");
            }
            index++;
        }
        extentTest.pass("Checkbox Test is Successful");
    }
}
