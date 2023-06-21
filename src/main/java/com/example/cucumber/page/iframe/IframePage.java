package com.example.cucumber.page.iframe;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.example.constants.Page.FRAMES_PAGE;
import static com.example.constants.Page.IFRAME_PAGE;
import static com.example.constants.PageLinkText.*;
import static org.junit.Assert.*;

public class IframePage extends WebDriverJavaUtil {
    WebDriver driver;
    ReadProperties readProperties = new ReadProperties();
    public IframePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By frame_page_link = By.linkText(FRAMES);
    private By iframe_page_link = By.linkText(IFRAME);

    public void the_user_clicks_on_the_frame_page() {
        clckOnWebElement(frame_page_link);
    }

    public void the_user_should_see_the_frame_page() {
        assertEquals("Frame Page URL doesn't Match: ", FRAMES_PAGE, driver.getCurrentUrl());

    }

    public void the_user_clicks_on_the_iframe_page() {
        clckOnWebElement(iframe_page_link);
    }

    public void the_user_should_see_the_iframe_page() {
        assertEquals("Iframe Page URL doesn't Match: ", IFRAME_PAGE, driver.getCurrentUrl());
    }

    public void the_user_switches_to_on_the_iframe_page(String iframeName) {
        driver.switchTo().frame(iframeName);
    }

    public void the_user_type_on_the_textbox_on_the_iframe_page(String testMessage) {
        enterStringInputBox(By.xpath("//*[@id='tinymce']/p"),testMessage);
        waitForMilliSeconds(2000);
    }

    public void the_user_should_not_see_the_text_on_the_iframe_on_the_iframe_page() {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        boolean elementNotPresent = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='tinymce']/p")));
        assertTrue("Text in not correct in correct Iframe:", elementNotPresent);
    }

    public void the_user_should_see_the_text_on_the_iframe_on_the_iframe_page(String testText, String iframeName) {
        driver.switchTo().frame(iframeName);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tinymce']/p")));
        assertEquals("Text in not correct in correct Iframe:", testText, getWebElementText(By.xpath("//*[@id='tinymce']/p")));
    }
}
