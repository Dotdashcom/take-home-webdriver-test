package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.NotificationMessagePage;
import testComponents.BaseTest;

public class NotificationMessageTest extends BaseTest {

    @Test
    public void notificationMessage(){
        NotificationMessagePage notificationMessagePage=new NotificationMessagePage(driver);
        notificationMessagePage.goTo();
        notificationMessagePage.clickOnButton();
        Assert.assertTrue(notificationMessagePage.clickButtonManyTimes());
    }
}
