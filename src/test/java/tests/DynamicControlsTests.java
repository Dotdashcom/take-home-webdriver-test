package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;



public class DynamicControlsTests extends TestBase {


    /**
     * 8. Dynamic Controls
     *
     * Test clicks on the Remove Button and uses explicit wait.
     * Test asserts that the checkbox is gone.
     * Test clicks on Add Button and uses explicit wait.
     * Test asserts that the checkbox is present.
     * Test clicks on the Enable Button and uses explicit wait.
     * Test asserts that the text box is enabled.
     * Test clicks on the Disable Button and uses explicit wait.
     * Test asserts that the text box is disabled.
     */
    @Test
    @DisplayName("Test clicks on the Remove Button and uses explicit wait.")
    public void dynamicControlTest() {
        Driver.getDriver().findElement(By.linkText("Dynamic Controls")).click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        WebElement removeBtn = Driver.getDriver().findElement(By.xpath("//*[text()='Remove']"));
        removeBtn.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));

        String actual = Driver.getDriver().findElement(By.id("message")).getText();
        String expected = "It's gone!";

        Assertions.assertEquals(expected, actual, "Message is not correct!");
    }

    @Test
    @DisplayName("Verify that the checkbox is gone.")
    public void dynamicControlTest2() {
        Driver.getDriver().findElement(By.linkText("Dynamic Controls")).click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        WebElement removeBtn = Driver.getDriver().findElement(By.xpath("//*[text()='Remove']"));
        removeBtn.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));

        try {
            Driver.getDriver().findElement(By.id("checkbox"));
            Assertions.fail("Checkbox present!");
        } catch (WebDriverException e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    @DisplayName("Test asserts that the checkbox is present.")
    public void dynamicControlTest3() {
        Driver.getDriver().findElement(By.linkText("Dynamic Controls")).click();
        Assertions.assertTrue(Driver.getDriver().findElement(By.id("checkbox")).isDisplayed(), "Checkbox is not there!");
    }

    @Test
    @DisplayName("Test clicks on the Enable Button and uses explicit wait.")
    public void dynamicControlTest4() {
        Driver.getDriver().findElement(By.linkText("Dynamic Controls")).click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        WebElement enableBtn = Driver.getDriver().findElement(By.xpath("//*[text()='Enable']"));
        enableBtn.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));

        try {
            Driver.getDriver().findElement(By.id("//*[text()='Enable']"));
            Assertions.fail("Checkbox present!");
        } catch (WebDriverException e) {
            Assertions.assertTrue(true);
        }

        WebElement disableBtn = Driver.getDriver().findElement(By.xpath("//*[text()='Disable']"));

        Assertions.assertTrue(disableBtn.isDisplayed());
    }

    @Test
    @DisplayName("Test asserts that the text box is enabled.")
    public void dynamicControlTest5() {
        Driver.getDriver().findElement(By.linkText("Dynamic Controls")).click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        WebElement enableBtn = Driver.getDriver().findElement(By.xpath("//*[text()='Enable']"));
        enableBtn.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));

        try {
            Driver.getDriver().findElement(By.id("//*[text()='Enable']"));
            Assertions.fail("Checkbox present!");
        } catch (WebDriverException e) {
            Assertions.assertTrue(true);
        }

        WebElement input = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));

        Assertions.assertTrue(input.isEnabled(), "Input is disabled");
    }

    @Test
    @DisplayName("Test clicks on the Disable Button and uses explicit wait.")
    public void dynamicControlTest6() {
        Driver.getDriver().findElement(By.linkText("Dynamic Controls")).click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        WebElement enableBtn = Driver.getDriver().findElement(By.xpath("//*[text()='Enable']"));
        enableBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
        WebElement msg = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));

        Assertions.assertEquals("It's enabled!", msg.getText(), "It's not enabled!");


        try {
            Driver.getDriver().findElement(By.id("//*[text()='Enable']"));
            Assertions.fail("Checkbox present!");
        } catch (WebDriverException e) {
            Assertions.assertTrue(true);
        }

        WebElement input = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));

        Assertions.assertTrue(input.isEnabled(), "Input is disabled");

        WebElement disableBtn = Driver.getDriver().findElement(By.xpath("//*[text()='Disable']"));
        disableBtn.click();
        msg = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));

        Assertions.assertEquals("It's disabled!", msg.getText(), "It's not disabled!");
    }

    @Test
    @DisplayName("Test asserts that the text box is disabled.")
    public void dynamicControlTest7() {
        Driver.getDriver().findElement(By.linkText("Dynamic Controls")).click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        WebElement enableBtn = Driver.getDriver().findElement(By.xpath("//*[text()='Enable']"));
        enableBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
        WebElement msg = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));

        Assertions.assertEquals("It's enabled!", msg.getText(), "It's not enabled!");


        try {
            Driver.getDriver().findElement(By.id("//*[text()='Enable']"));
            Assertions.fail("Checkbox present!");
        } catch (WebDriverException e) {
            Assertions.assertTrue(true);
        }

        WebElement input = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));

        Assertions.assertTrue(input.isEnabled(), "Input is disabled");

        WebElement disableBtn = Driver.getDriver().findElement(By.xpath("//*[text()='Disable']"));
        disableBtn.click();
        msg = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));

        Assertions.assertEquals("It's disabled!", msg.getText(), "It's not disabled!");

        input = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));

        Assertions.assertFalse(input.isEnabled(), "Input is enabled");
    }

}
