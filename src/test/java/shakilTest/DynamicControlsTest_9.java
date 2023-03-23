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


public class DynamicControlsTest_9 extends TestBase {

    @Test
    public void DynamicControlsTest() throws InterruptedException {
        driver.get("http://localhost:7080/dynamic_loading/2");
        
        // Find the "Enable" button and click it
        WebElement enableButton = driver.findElement(By.cssSelector("button"));
        enableButton.click();
        
        // Wait for the message to appear using explicit wait
        Boolean enableMessage = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='finish']/h4[.='Hello World!']"), "Hello World!"));
        
        // Verify that the message is visible
        Assert.assertTrue(enableMessage);
    }
}
