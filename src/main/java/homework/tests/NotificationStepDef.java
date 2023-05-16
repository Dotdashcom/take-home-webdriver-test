package homework.tests;

import homework.pages.NotificationPage;
import homework.test.TestBase;
import homework.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationStepDef extends TestBase {

    NotificationPage notificationPage=new NotificationPage();

    @Test
    public void verifyMessages(){

        Driver.getDriver().get("http://localhost:7080/notification_message_rendered");
        boolean showenMessages = true;

        for (int i=0; i<5; i++){
            notificationPage.clickHereLink.click();

            if (notificationPage.messages.equals("Action successful") ||
                    notificationPage.messages.equals("Action unsuccessful, please try again") ||
                    notificationPage.messages.equals("Action Unsuccessful")){

                System.out.println(showenMessages);

            }
        }


    }
}
