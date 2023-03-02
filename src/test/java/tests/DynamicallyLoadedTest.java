package tests;

import enums.Headers;
import enums.Messages;
import enums.Pages;
import org.testng.annotations.Test;
import pages.DynamicallyLoadedPage;
import utilities.BrowserUtils;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicallyLoadedTest extends TestBase {
    @Test(description = "Dynamically Loaded Test")
    public void dynamicContentTest() {
        DynamicallyLoadedPage dynamicallyLoadedPage = new DynamicallyLoadedPage();
        BrowserUtils.openPage(driver, Pages.DYNAMICALLY_LOADED_PAGE);
        BrowserUtils.waitUntilVisible(driver, dynamicallyLoadedPage.header, Duration.ofSeconds(15));
        assertThat(dynamicallyLoadedPage.header.getText()).isEqualTo(Headers.DYNAMICALLY_LOADED_PAGE_ELEMENT.getName());
        dynamicallyLoadedPage.startButton.click();
        BrowserUtils.waitUntilVisible(driver, dynamicallyLoadedPage.message, Duration.ofSeconds((15)));
        assertThat(dynamicallyLoadedPage.message.getText()).isEqualTo(Messages.MESSAGE.getMessage());
    }
}