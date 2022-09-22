package com.mitt.test;

import com.mitt.pages.NotificationMessagePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NotificationMessageTests extends BaseTest{

    NotificationMessagePage notificationMessagePage;

    @BeforeClass
    public void setUp(){
        notificationMessagePage = new NotificationMessagePage(getDriver(), getWait());
    }

    @Test
    public void test_click_here_link(){
        notificationMessagePage.verify_click_here_link();
    }

}
