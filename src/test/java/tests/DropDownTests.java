package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

public class DropDownTests extends TestBase {

    /**
     * 6. Dropdown
     *
     * Test selects Option 1 and Option 2 from the drop down menu.
     * Test asserts Option 1 and Option 2 are selected.
     */
    @Test
    @DisplayName("Verify dropdown")
    public void dropDownTest() {
        Driver.getDriver().findElement(By.linkText("Dropdown")).click();

        WebElement dropdown = Driver.getDriver().findElement(By.id("dropdown"));
        Select select = new Select(dropdown);

        select.selectByVisibleText("Option 1");
        Assertions.assertEquals(select.getFirstSelectedOption().getText(), "Option 1", "Incorrect selected option!");

        select.selectByVisibleText("Option 2");
        Assertions.assertEquals(select.getFirstSelectedOption().getText(), "Option 2", "Incorrect selected option!!");
    }
}
