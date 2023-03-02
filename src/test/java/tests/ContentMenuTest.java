package tests;

import enums.AlertMsgs;
import enums.Headers;
import enums.Pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.ContentMenuPage;
import utilities.BrowserUtils;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class ContentMenuTest extends TestBase {

    @Test(description = "Content menu test")
    public void verifyContentMenu() {
        ContentMenuPage contentMenuPage = new ContentMenuPage();
        BrowserUtils.openPage(driver, Pages.CONTENT_MENU_PAGE);
        BrowserUtils.waitUntilVisible(driver, contentMenuPage.header, Duration.ofSeconds(15));
        assertThat(contentMenuPage.header.getText()).isEqualTo(Headers.CONTENT_MENU.getName());
        new Actions(driver).moveToElement(contentMenuPage.frame).contextClick().build().perform();
        Alert alert = driver.switchTo().alert();
        assertThat(alert.getText()).contains(AlertMsgs.CONTENT_MENU_ALERT.getMessage());
    }
}
