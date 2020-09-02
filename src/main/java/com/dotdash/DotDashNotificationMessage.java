package com.dotdash;

import org.jsoup.Connection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.dotdash.DotDashWebElements.*;

/**
 * Created by Denys on 9/1/20
 **/
public class DotDashNotificationMessage extends BaseAPI {

    @FindBy(how = How.LINK_TEXT, using = clickHereNotificationLT) public WebElement clickHereForNotification;
    @FindBy(how = How.CSS, using = notificationMessageCss) public WebElement notificationMessage;


    static DotDashNotificationMessage notification;

    public static void initPage() {
        notification = PageFactory.initElements(driver, DotDashNotificationMessage.class);
    }


    public static void triggerNotification() {
        initPage();
        click(notification.clickHereForNotification);
    }

    public static void assertNotificationMessageIsDisplayed() {
        initPage();
        Assert.assertTrue(notification.notificationMessage.isDisplayed());

    }

    public static void navigateToNotficationMesagePage() {
        driver.get(baseURL + "notification_message_rendered");
    }


}
