package com.automation.tests;

import org.testng.annotations.Test;

public class NotificationMessageTest extends BaseTest {

    @Test
    public void test() {
        notificationMessagePage.clickOnLink();
        notificationMessagePage.verifyMessage();
    }
}
