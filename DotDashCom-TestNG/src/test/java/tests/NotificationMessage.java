package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.NotificationMessagePage;
import utilities.ConfigReader;
import utilities.Driver;

public class NotificationMessage {

    NotificationMessagePage notificationMessagePage = new NotificationMessagePage();
    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl")+"notification_message_rendered");
        do {
            notificationMessagePage.clickHere.click();
        }
        while (notificationMessagePage.message.toString().equals("Action Successful"));

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
