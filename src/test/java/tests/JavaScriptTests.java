package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.util.List;

public class JavaScriptTests extends TestBase {
    /**
     * 15. JavaScript Alerts
     * <p>
     * Test Clicks on JS Alert Button.
     * Test asserts alert message.
     * Test clicks on JS confirm Button and clicks ok on alert.
     * Test asserts the alert message.
     * Test clicks on JS Prompt Button and types a message on Prompt.
     * Test asserts that the alert message contains the typed message.
     *
     * @throws InterruptedException
     */
    @Test
    @DisplayName("JavaScript Alerts")
    public void jsAlertTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Driver.getDriver().findElement(By.linkText("JavaScript Alerts")).click();

        List<WebElement> listOfAlertButtons = Driver.getDriver().findElements(By.tagName("button"));

        listOfAlertButtons.get(0).click();//trigger first alert
        wait.until(ExpectedConditions.alertIsPresent());

        String expectedMsg = "I am a JS Alert";
        String actualMsg = Driver.getDriver().switchTo().alert().getText();

        Assertions.assertEquals(expectedMsg, actualMsg, "Alert message is not matching!");
        Driver.getDriver().switchTo().alert().accept();

        listOfAlertButtons.get(1).click();//trigger second alert
        wait.until(ExpectedConditions.alertIsPresent());

        String expectedMsg2 = "I am a JS Confirm";
        String actualMsg2 = Driver.getDriver().switchTo().alert().getText();

        Assertions.assertEquals(expectedMsg2, actualMsg2, "Alert message is not matching!");
        Driver.getDriver().switchTo().alert().accept();

        listOfAlertButtons.get(2).click();//trigger third alert
        wait.until(ExpectedConditions.alertIsPresent());

        String expectedMsg3 = "I am a JS Confirm";
        Driver.getDriver().switchTo().alert().sendKeys(expectedMsg3);
        Driver.getDriver().switchTo().alert().accept();

        String actualMsg3 = Driver.getDriver().findElement(By.id("result")).getText().replace("You entered:", "").trim();
        Assertions.assertEquals(expectedMsg3, actualMsg3, "Result message is not matching!");
    }
}
