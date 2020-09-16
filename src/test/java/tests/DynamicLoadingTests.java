package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

public class DynamicLoadingTests extends TestBase {

    /**
     * 9. Dynamic Loading
     *
     * Test clicks the start button and uses explicit wait.
     * Test asserts that “Hello World!” text is displayed.
     * @throws InterruptedException
     */
    @Test
    @DisplayName("Test clicks the start button and uses explicit wait.")
    public void dynamicLoadingTest1() throws InterruptedException {
        Driver.getDriver().findElement(By.linkText("Dynamic Loading")).click();
        Driver.getDriver().findElement(By.linkText("Example 1: Element on page that is hidden")).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        WebElement startBtn = Driver.getDriver().findElement(By.xpath("//button[text()='Start']"));
        wait.until(ExpectedConditions.elementToBeClickable(startBtn));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", startBtn);

        WebElement finish = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
        String actual = wait.until(ExpectedConditions.visibilityOf(finish)).getText();
        String expected = "Hello World!";

        Assertions.assertEquals(expected, actual, "Message is not matching");
    }


    @Test
    @DisplayName("Test clicks the start button and uses explicit wait.")
    public void dynamicLoadingTest2() throws InterruptedException {
        Driver.getDriver().findElement(By.linkText("Dynamic Loading")).click();
        Driver.getDriver().findElement(By.linkText("Example 2: Element rendered after the fact")).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        WebElement startBtn = Driver.getDriver().findElement(By.xpath("//button[text()='Start']"));
        wait.until(ExpectedConditions.elementToBeClickable(startBtn));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", startBtn);

        WebElement finish = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
        String actual = wait.until(ExpectedConditions.visibilityOf(finish)).getText();
        String expected = "Hello World!";

        Assertions.assertEquals(expected, actual, "Message is not matching");
    }
}
