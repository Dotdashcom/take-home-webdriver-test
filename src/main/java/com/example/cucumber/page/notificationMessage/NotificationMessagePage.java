package com.example.cucumber.page.notificationMessage;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Logger;

import static com.example.constants.Page.NOTIFICATION_MESSAGE_PAGE;
import static com.example.constants.PageLinkText.NOTIFICAION_MESSAGES;
import static org.junit.Assert.assertEquals;
public class NotificationMessagePage extends WebDriverJavaUtil {
    WebDriver driver;
    ReadProperties readProperties = new ReadProperties();
    public NotificationMessagePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    Logger log = Logger.getLogger(NotificationMessagePage.class.getName());
    private By notification_message_page_link = By.linkText(NOTIFICAION_MESSAGES);
    public void the_user_clicks_on_the_notification_message_page() {
        clckOnWebElement(notification_message_page_link);
    }
    public void the_user_should_see_the_notification_message_page() {
        assertEquals("Notification Message Page URL doesn't Match: ", NOTIFICATION_MESSAGE_PAGE, driver.getCurrentUrl());
    }
    public void theUserClicksOnTheLinkToSeeNotificationOnTheNotificationMessagePage(String clickHereLink, String expectedMessage) {
        String clickHereXpath = "//a[contains(text(),'" + clickHereLink +"')]";
        boolean messageDisplayed = false;

        int maxAttempts = 10;
        int attemptCount = 0;
        do {
            clckOnWebElement(By.xpath(clickHereXpath));
            WebDriverWait wait = new WebDriverWait(driver, 1);
            WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
            String actualMessage = messageElement.getText();
            log.info("Attempt count: " + attemptCount);
            if (actualMessage.contains(expectedMessage)) {
                messageDisplayed = true;
                log.info("Desired message is displayed: " + actualMessage);
                break;
            }
            attemptCount++;
        } while (attemptCount < maxAttempts);
        assertEquals("Desired message not displayed within max Attempts: ", true, messageDisplayed);
    }
}
