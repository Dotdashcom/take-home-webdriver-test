package com.company.tests;

import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

/**
 * Test clicks on the Remove Button and uses explicit wait.
 * Test asserts that the checkbox is gone.
 * Test clicks on Add Button and uses explicit wait.
 * Test asserts that the checkbox is present.
 * Test clicks on the Enable Button and uses explicit wait.
 * Test asserts that the text box is enabled.
 * Test clicks on the Disable Button and uses explicit wait.
 * Test asserts that the text box is disabled.
 */

public class TestCase08DynamicControls {

    @Test
    public void dynamicControls() {

        Driver.getDriver().get("http://localhost:7080/dynamic_controls");

        /*
         Test clicks on the Remove Button and uses explicit wait.
         Test asserts that the checkbox is gone.*/

        WebElement RemoveAddButton = Driver.getDriver().findElement(By.xpath("//*[@id='checkbox-example']/button"));
        WebElement CheckBox = Driver.getDriver().findElement(By.xpath("//*[@id='checkbox']"));
        assertTrue(CheckBox.isDisplayed());

        RemoveAddButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(CheckBox));

        /*
         Test clicks on Add Button and uses explicit wait.
         Test asserts that the checkbox is present.
         */
        RemoveAddButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='checkbox']")));

        WebElement EnableDisableButton = Driver.getDriver().findElement(By.xpath("//*[@id='input-example']/button"));

        WebElement inputBox = Driver.getDriver().findElement(By.xpath("//*[@id='input-example']/input"));
        assertTrue(inputBox.isDisplayed());

        EnableDisableButton.click();
        /* Enabled */
        wait.until(ExpectedConditions.elementSelectionStateToBe(inputBox, inputBox.isEnabled()));

        EnableDisableButton.click();
        /* Disabled */
        wait.until(ExpectedConditions.attributeToBeNotEmpty(inputBox,"disabled"));

        Driver.closeDriver();
    }
}
