package task.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.pages.NotificationMessagePage;
import task.utilities.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotificationMessage {


    NotificationMessagePage notificationMessagePage = new NotificationMessagePage();

    List<String> expectedMessages = new ArrayList<>();

    String actualMessage;


    @BeforeEach
    public void setUp(){
        Driver.getDriver().get("http://localhost:7080/notification_message_rendered");
    }


    @Test
    public void testNotificationMessage(){

        expectedMessages.add("Action successful");
        expectedMessages.add("Action Unsuccessful");
        expectedMessages.add("Action unsuccessful, please try again");


        boolean isShown = false;

        for (int i = 0; i < 5; i++) {

            notificationMessagePage.notificationLink.click();
            actualMessage = notificationMessagePage.messageBox.getText().trim();


            Assertions.assertTrue(actualMessage.contains("Action successful")
                    || actualMessage.contains("Action unsuccesful, please try again")
                    || actualMessage.contains("Action Unsuccessful"));



        }




    }


    @AfterEach
    public void tearDown() {
        Driver.closeDriver();
    }
}
