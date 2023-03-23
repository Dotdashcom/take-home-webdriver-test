package shakilTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DynamicControlsTest_8 extends TestBase {


    @Test
    public void DynamicControlsTest() throws InterruptedException {
        driver.get("http://localhost:7080/dynamic_controls");

        // Find the checkbox with type='checkbox'
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));

        // Verify that the checkbox is unchecked by default
        Assert.assertFalse(checkbox.isSelected());

        // Click on the checkbox to check it
        checkbox.click();

        // Verify that the checkbox is checked
        Assert.assertTrue(checkbox.isSelected());

        // Click on the "Remove" button
        WebElement removeButton = driver.findElement(By.xpath("//form[@id='checkbox-example']/button[@type='button']"));
        removeButton.click();

        // Wait for the message to appear using explicit wait
        Boolean message = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[@id='message']"), "It's gone!"));

        // Verify that the message is visible
        Assert.assertTrue(message);
        
        // Find the "Enable" button and click it
        WebElement enableButton = driver.findElement(By.xpath("//form[@id='input-example']/button[@type='button']"));
        enableButton.click();
        
        // Wait for the message to appear using explicit wait
        Boolean enableMessage = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[@id='message']"), "It's enabled!"));
        
        // Verify that the message is visible
        Assert.assertTrue(enableMessage);
    }
}
