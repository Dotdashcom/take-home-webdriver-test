package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.CheckBoxesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class CheckBoxes {
    CheckBoxesPage checkBoxesPage = new CheckBoxesPage();

    @Test()
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl") + "checkboxes"); //Go to "http://localhost:7080/checkboxes" URL
        ReusableMethods.waitForPageToLoad(3); //Page load waiting for 3 seconds

        int index = 1;

        for (WebElement checkbox : checkBoxesPage.checkboxes) {
            if (checkbox.isEnabled() && !checkbox.isSelected()) {
                checkbox.click();
                System.out.println(("Checkbox #" + index + " was not clicked"));
                Assert.assertTrue(checkbox.isSelected());
                System.out.println(("Checkbox " + index + " is selected"));
            } else {
                checkbox.click();
                System.out.println(("Checkbox #" + index + " was clicked"));
                Assert.assertFalse(checkbox.isSelected());
                System.out.println(("Checkbox " + index + " is un-selected"));
            }

            index++;
        }}

    @AfterMethod
    public void tearDown () {
        Driver.closeDriver();
    }

}
