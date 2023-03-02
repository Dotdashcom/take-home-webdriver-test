package tests;

import enums.Pages;
import org.testng.annotations.Test;
import pages.IframePage;
import utilities.BrowserUtils;

import java.time.Duration;
import static org.assertj.core.api.Assertions.assertThat;


public class IframeTest extends TestBase {


    @Test(description = "Iframe test")
    public void iframeTest()  {
        IframePage iframePage = new IframePage();
        BrowserUtils.openPage(driver, Pages.IFRAME_PAGE);
        BrowserUtils.waitUntilVisible(driver, iframePage.closeAlertBtn, Duration.ofSeconds(15));
        iframePage.closeAlertBtn.click();
        BrowserUtils.waitUntilVisible(driver, iframePage.frame, Duration.ofSeconds(15));
        driver.switchTo().frame(iframePage.frame);
        iframePage.inputText.clear();
        iframePage.inputText.sendKeys("HELLO");
        assertThat(iframePage.inputText.getText()).isEqualTo("HELLO");
        driver.switchTo().defaultContent();
    }
}
