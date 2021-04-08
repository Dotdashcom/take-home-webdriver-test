package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.NotificationMessagePage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;



public class TestNotificationMessage {
    NotificationMessagePage notificationMessagePage = new NotificationMessagePage();

    @Before
    public void setUp() {
        String url = ConfigReader.readProperty("url") + "notification_message_rendered";
        Driver.getDriver().get(url);
    }

    @Test
    public void testNotificationMessage() {
        for (int i = 0; i < 5; i++) {
            notificationMessagePage.clickHere.click();
            BrowserUtils.sleepSeconds(2);
            BrowserUtils.highlightElement(notificationMessagePage.notificationText);
        }
            Assert.assertTrue(notificationMessagePage.notificationText.getText().contains("Action successful")
                    || notificationMessagePage.notificationText.getText().contains("Action unsuccessful, please try again"));
    }
    @After
    public void tearDown() {
            Driver.quitDriver();
        }
}
