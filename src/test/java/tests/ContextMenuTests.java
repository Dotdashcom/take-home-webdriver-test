package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.CheckboxesPage;
import utils.Driver;

public class ContextMenuTests extends TestBase {

    /**
     * 4. Context Menu
     *
     * Test right clicks on the context menu.
     * Test asserts the alert menu text.
     */

    @Test
    @DisplayName("Verify right clicks on the context menu.")
    public void contextMenuTest() {
        Driver.getDriver().findElement(By.linkText("Context Menu")).click();
        WebElement contextMenu = Driver.getDriver().findElement(By.id("hot-spot"));

        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(contextMenu).perform();

        String expected = "You selected a context menu";
        String actual = "";
        try {
            actual = Driver.getDriver().switchTo().alert().getText();
        } catch (Exception e) {
            Assertions.fail("Alert is not present!");
        }
        Assertions.assertEquals(expected, actual, "Alert message is not correct");
    }
}
