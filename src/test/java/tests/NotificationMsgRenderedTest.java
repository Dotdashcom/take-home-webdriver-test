package tests;

import Pages.NotificationMsgRendered_Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class NotificationMsgRenderedTest {
    public String Url_notification_msg_rendered="notification_message_rendered";
    WebDriver driverDotDash;
    NotificationMsgRendered_Page notificationMsgRendered_page;
    @Before
    public void setUp(){
        notificationMsgRendered_page=new NotificationMsgRendered_Page(driverDotDash);
        notificationMsgRendered_page.setChrome();
        notificationMsgRendered_page.setUrl(Url_notification_msg_rendered);
    }

    @Test
    public void notificationNdAssert() {
        notificationMsgRendered_page.clicklinkToNotification();
    }

    @After
    public void tearDown(){
        notificationMsgRendered_page.closeAllWindows();
    }
}
