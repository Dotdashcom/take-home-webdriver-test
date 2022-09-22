package com.dotdash.tests;

import com.dotdash.pages.NotificationMessagePage;
import com.dotdash.pages.TestBase;
import com.dotdash.utilities.Driver;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;

public class NotificationMessageTest extends TestBase {


    @Test
    public void notificationTest() {

        NotificationMessagePage notificationMessagePage = new NotificationMessagePage();
        notificationMessagePage.navigatePages("Notification Messages");

        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(notificationMessagePage.clickHere);
        actions.click(notificationMessagePage.clickHere);

        System.out.println(notificationMessagePage.flashNotice.getText());

        Assertions.assertTrue(notificationMessagePage.flashNotice.getText().contains("Action unsuccessful, please try again") || notificationMessagePage.flashNotice.getText().contains("Action successful") || notificationMessagePage.flashNotice.getText().contains("Action unsuccessful"));

    }
}
