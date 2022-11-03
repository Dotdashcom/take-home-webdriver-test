package testcases;

import com.example.testautomation_dotdash.base.BaseTest;
import com.example.testautomation_dotdash.pages.NotificationMessagesPage;
import org.junit.Test;

public class NotificationMessagesTest extends BaseTest {


    public NotificationMessagesTest(){
        super();
    }


    @Test
    public void VerifyNotificationMessages(){

        NotificationMessagesPage notificationMessagesPage = new NotificationMessagesPage(driver);
        notificationMessagesPage.clickUntilOneOfTheMessagesBeDisplayed10Times();
    }
}
