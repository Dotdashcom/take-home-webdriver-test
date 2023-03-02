package tests;

import enums.Pages;
import org.testng.annotations.Test;
import pages.JSAlertPage;
import utilities.BrowserUtils;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class JSAlertTest extends TestBase {

    @Test(description = "JSAert Test")
    public void jsAlertTest() {
        JSAlertPage jsAlertPage = new JSAlertPage();
        BrowserUtils.openPage(driver, Pages.JSALERT_PAGE);
        BrowserUtils.waitUntilVisible(driver, jsAlertPage.header, Duration.ofSeconds(15));

        jsAlertPage.JSAlertBtn.click();
        BrowserUtils.AlertSwitchGetTextAndAccept(driver);
        assertThat(jsAlertPage.message.getText()).isEqualTo("You successfuly clicked an alert");

        jsAlertPage.JSConfirmAlertBtn.click();
        BrowserUtils.AlertSwitchGetTextAndAccept(driver);
        assertThat(jsAlertPage.message.getText()).isEqualTo("You clicked: Ok");

        jsAlertPage.JSPromptAlertBtn.click();
        BrowserUtils.AlertSwitchSendKeysAndAccept(driver, "Hello");
        assertThat(jsAlertPage.message.getText()).contains("Hello");
    }
}
