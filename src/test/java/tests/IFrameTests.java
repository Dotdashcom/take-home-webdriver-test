package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

public class IFrameTests extends TestBase{

    /**
     * 13. Iframe
     *
     * Test switches to Iframe and types some text.
     * Test asserts that the typed text is as expected.
     * @throws InterruptedException
     */
    @Test
    @DisplayName("Test switches to Iframe and types some text and asserts that the typed text is as expected.")
    public void iframeTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Driver.getDriver().findElement(By.linkText("Frames")).click();
        Driver.getDriver().findElement(By.linkText("iFrame")).click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mce_0_ifr")));

        WebElement input = Driver.getDriver().findElement(By.id("tinymce"));
        String text = "Some text...";

        input.clear();
        input.sendKeys(text);

        Assertions.assertEquals(text,input.getText(), "Text is not correct!");
    }
}
