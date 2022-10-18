package com.dotdash.testcases;

import com.dotdash.pageObject.NotificationPage;
import com.framework.libraries.MyTestClasses;
import org.testng.annotations.Test;

public class Notification extends Setup {
    NotificationPage notificationPage;

    public Notification(){
        this.notificationPage= MyTestClasses.getObject(NotificationPage.class);
    }

    @Test(testName = "validate notification message displayed")
    public void validateNotificationDisplayed(){
        navigateTo("notification_message_rendered");
        notificationPage.clickToGetMessage();
        notificationPage.assertMessage("Action successful\n" +
                "×");
    }

}
