package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.util.List;

public class MouseHoverTests extends TestBase {


    /**
     * 14. Mouse Hover
     * <p>
     * Test does a mouse hover on each image.
     * Test asserts that additional information is displayed for each image.
     */

    @Test
    @DisplayName("Test does a mouse hover on each image and asserts that additional information is displayed for each image.")
    public void mouseHoverTest() throws Exception {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Driver.getDriver().findElement(By.linkText("Hovers")).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("figure"), 3));
        List<WebElement> images = Driver.getDriver().findElements(By.className("figure"));
        Actions actions = new Actions(Driver.getDriver());

        for (int index = 0; index < images.size(); index++) {
            WebElement img = images.get(index);
            wait.until(ExpectedConditions.visibilityOf(img));
            Thread.sleep(1000);//wait for demo
            actions.doubleClick(img).pause(1000).perform();
            List<WebElement> imgTitleList = Driver.getDriver().findElements(By.tagName("h5"));

            Assertions.assertTrue(imgTitleList.get(index).isDisplayed(), "Image title is not displayed!");
        }
    }
}
