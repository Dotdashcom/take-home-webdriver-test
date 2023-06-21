package com.example.cucumber.page.openInNewTab;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static com.example.constants.Page.NEW_WINDOW_TEST_PAGE;
import static com.example.constants.Page.OPEN_NEW_TAB_PAGE;
import static com.example.constants.PageLinkText.MULTIPLE_WINDOWS;
import static org.junit.Assert.assertEquals;

public class OpenInNewTabPage extends WebDriverJavaUtil {
    WebDriver driver;
    ReadProperties readProperties = new ReadProperties();
    public OpenInNewTabPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By javascript_multiple_windows_page_link = By.linkText(MULTIPLE_WINDOWS);
    public void the_user_clicks_on_the_open_new_tab_page() {
        clckOnWebElement(javascript_multiple_windows_page_link);
    }

    public void the_user_should_see_the_open_new_tab_page() {
        assertEquals("Open New Tab Page URL doesn't Match: ", OPEN_NEW_TAB_PAGE, driver.getCurrentUrl());
    }

    public void the_user_clicks_on_the_link_on_the_open_new_tab_page(String clickHere) {
        String clickHereXpath = "//a[contains(text(),'" + clickHere +"')]";
        clckOnWebElement(By.xpath(clickHereXpath));
        waitForMilliSeconds(1000);
    }

    public void the_user_should_see_the_new_tab_is_opened_with_text(String text) {
        String parentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        // Switch to the new window
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        waitForMilliSeconds(2000);
        assertEquals("New Tab Page URL doesn't Match: ", NEW_WINDOW_TEST_PAGE, driver.getCurrentUrl());
        assertEquals("New Window text not correct: ", text, getWebElementText(By.cssSelector("h3")) );
    }
}
