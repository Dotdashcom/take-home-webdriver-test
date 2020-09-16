package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.CheckboxesPage;
import pages.LoginPage;
import utils.Driver;

public class CheckBoxTests extends TestBase {

    /**
     * 3. Checkboxes
     *
     * Test checks and unchecks checkboxes.
     * Test uses assertions to make sure boxes were properly checked and unchecked.
     */
    @Test
    @DisplayName("Verify check boxes can be selected and unselected")
    public void checkBoxTest() {
        CheckboxesPage checkboxesPage = new CheckboxesPage();
        Driver.getDriver().findElement(By.linkText("Checkboxes")).click();

        checkboxesPage.checkbox1.click();
        checkboxesPage.checkbox2.click();

        Assertions.assertTrue(checkboxesPage.checkbox1.isSelected(), "Check box 1 is not selected!");
        Assertions.assertFalse(checkboxesPage.checkbox2.isSelected(), "Check box 1 selected!");

    }
}
