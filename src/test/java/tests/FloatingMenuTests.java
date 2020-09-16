package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class FloatingMenuTests extends TestBase{

    /**
     * 12. Floating Menu
     *
     * Test scrolls the page.
     * Test asserts that the floating menu is still displayed.
     * @throws InterruptedException
     */
    @Test
    @DisplayName("Test scrolls the page and asserts that the floating menu is still displayed.")
    public void floatingMenuTest() throws InterruptedException {
        Driver.getDriver().findElement(By.linkText("Floating Menu")).click();

        WebElement menu = Driver.getDriver().findElement(By.id("menu"));
        Assertions.assertTrue(menu.isDisplayed(), "Menu is not displayed!");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, 4000)");
        Thread.sleep(2000);
        Assertions.assertTrue(menu.isDisplayed(), "Menu is not displayed!");
    }
}
