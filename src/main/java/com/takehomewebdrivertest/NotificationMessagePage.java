package com.takehomewebdrivertest;

import com.takehomewebdrivertest.dataprovider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class NotificationMessagePage extends BasePage {

    public NotificationMessagePage(WebDriver driver) {
        super(driver);
    }
    ConfigFileReader configFileReader;

    private final String URL = "/notification_message_rendered";
    private final By pageTitle = By.cssSelector("h3");
    private final By link = By.cssSelector("a[href=\"/notification_message\"]");
    private final By notification = By.id("flash");

    public void navigateToNotificationMessagePage() throws Exception {
        configFileReader= new ConfigFileReader();
        driver.get(configFileReader.getBaseUrl() + "/notification_message_rendered");
        assertThat(getCurrentUrl()).contains(URL);
        String pageTitleText = driver.findElement(pageTitle).getText();
        assertThat(pageTitleText).contains("Notification Message");
    }

    public void clickOnNotificationGeneratorLink() throws Exception {
        click(link);
    }

    public void validateNotificationMessage() throws InterruptedException {
        String notificationText = driver.findElement(notification).getText();
        assertThat(notificationText.contains("Action successful") || notificationText.contains("Action unsuccesful, please try again"));
        threadSleep(2500);
    }
}
