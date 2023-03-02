package tests;

import enums.Pages;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FloatingMenuPage;
import utilities.BrowserUtils;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class FloatingMenu extends TestBase {

    @Test(description = "Floating Menu")
    public void floatingMenuTest()  {
        FloatingMenuPage floatingMenuPage=new FloatingMenuPage();
        BrowserUtils.openPage(driver, Pages.FLOATING_MENU_PAGE);
        BrowserUtils.waitUntilVisible(driver, floatingMenuPage.header, Duration.ofSeconds(15));
        WebElement f  = floatingMenuPage.lastElementOnPage;
        BrowserUtils.scrollToElement(driver, f);
        assertThat(floatingMenuPage.menuBtn.isDisplayed()).isTrue();
        assertThat(floatingMenuPage.homeBtn.isDisplayed()).isTrue();
        assertThat(floatingMenuPage.newsBtn.isDisplayed()).isTrue();
        assertThat(floatingMenuPage.contactBtn.isDisplayed()).isTrue();
        assertThat(floatingMenuPage.aboutBtn.isDisplayed()).isTrue();
    }
}
