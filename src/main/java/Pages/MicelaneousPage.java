package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class MicelaneousPage {
    public WebDriver driver;
    public Helpers helpers;

    public MicelaneousPage(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT
    public By here_click_windows = By.linkText("Click Here");
    public By here_click_notification = By.linkText("Click here");
    public By body_div = By.className("example");
    public By id_flash_div = By.id("flash");

    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES
    public void GoToWindows() {

        driver.navigate().to(driver.getCurrentUrl() + "windows");
    }

    public void GoToNotifications() {

        driver.navigate().to(driver.getCurrentUrl() + "notification_message_rendered");
    }

    public void OpenNewWindow() {
        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        helpers.Click(here_click_windows);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertEquals(helpers.getText(body_div), "New Window");
    }

    public void LoadNewMessage() {
        helpers.Click(here_click_notification);

    }

    public void AssertMessageDisplayed() {
        List<String> possibles_results = Arrays.asList("Action successful", "Action unsuccessful, please try again");
        helpers.Click(here_click_notification);
        String message_without_x = helpers.removeLastChar(helpers.getText(id_flash_div)).stripTrailing();
        helpers.Print(message_without_x);
        Assert.assertTrue(possibles_results.contains(message_without_x));

    }


}
