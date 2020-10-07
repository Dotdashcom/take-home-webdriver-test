package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.NotificationPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//Testcase description: Notification Message: http://localhost:7080/notification_message_rendered Test notification Message.
public class TC18_Notification extends baseClass {

    @Test(invocationCount = 3)
    public void notification()
    {
        //Launch url
        driver.get(baseURL+"/notification_message_rendered");

        //Create an object for NotificationPage
        NotificationPage notificationPage = new NotificationPage(driver);

        //Click on the Click here link
        notificationPage.clklnkClickhere();

        SoftAssert assertion = new SoftAssert();
        //Validate whether one of the “Action Successful”, “Action unsuccessful, please try again”
        // and “Action Unsuccessful” messages show on click

        assertion.assertTrue(notificationPage.gettxtnotification().contains("Action unsuccesful, please try again")
                ||(notificationPage.gettxtnotification().contains("Action successful"))
                ||(notificationPage.gettxtnotification().contains("Action Unsuccessful")));

        assertion.assertAll();
    }
}
