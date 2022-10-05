package com.dotdash.tests;

import com.dotdash.base.TestBase;
import com.dotdash.pages.NotificationMessagePage;

import com.dotdash.utilities.DriverUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions ;

public class Test_18_NotificationMessage extends TestBase {
@Test
    public void notification_test() {

        NotificationMessagePage notificationMessagePage = new NotificationMessagePage();
        notificationMessagePage.navigatePages("Notification Messages");

        Actions actions = new Actions(DriverUtils.getDriver());
        actions.doubleClick(notificationMessagePage.clickHere);
        actions.click(notificationMessagePage.clickHere);

        System.out.println(notificationMessagePage.flashNotice.getText());
    System.out.println(notificationMessagePage.flashNotice.getText());
    Assertions.assertTrue(notificationMessagePage.flashNotice.getText().contains("Action unsuccesful, please try again") || notificationMessagePage.flashNotice.getText().contains("Action successful"));

    }
}
