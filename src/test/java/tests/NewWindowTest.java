package tests;

import enums.Pages;
import org.testng.annotations.Test;
import pages.NewWindowPage;
import utilities.BrowserUtils;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class NewWindowTest extends TestBase {

    @Test(description = "New Tab Open Test")
    public void newWindowTest() {
        NewWindowPage newWindowPage = new NewWindowPage();
        BrowserUtils.openPage(driver, Pages.NEW_WINDOW_PAGE);
        BrowserUtils.waitUntilVisible(driver, newWindowPage.header, Duration.ofSeconds(15));
        String actualTitleBeforeClick = driver.getTitle();
        newWindowPage.clickHereBtn.click();
        BrowserUtils.windowHandle(driver);
        String expectedTitleAfterClick = newWindowPage.header.getText();
        assertThat(actualTitleBeforeClick).isNotEqualTo(expectedTitleAfterClick);
        assertThat(expectedTitleAfterClick).isEqualTo("New Window");
    }
}
