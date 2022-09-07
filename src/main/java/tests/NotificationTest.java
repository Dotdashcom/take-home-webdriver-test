package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.NotificationPage;
import pages.utils;

import java.util.ArrayList;

public class NotificationTest {
    NotificationPage notificationPage;

    public NotificationTest() {
        notificationPage = new NotificationPage();
    }

    @Test
    public void notificationTest() {
        WebDriver driver = TestBase.getInstance().getDriver();
        driver.get(utils.url + "/notification_message_rendered");
        String msg = "Action successful";

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            notificationPage.clickHereLink();
            list.add(notificationPage.getNotificationMessage().getText());
        }
        for (String str : list) {
            if (str.trim().contains(msg))
                System.out.println(str + "passed");
        }
    }

    @AfterTest
    public void teardown() {
        TestBase.getInstance().getDriver().quit();
    }
}



