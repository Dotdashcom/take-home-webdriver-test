package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.NotificationMessagePage;

public class NotificationMessageSteps {

    NotificationMessagePage notificationMessagePage = new NotificationMessagePage();

    @Step("Click Here link a multiple times")
    public void multipleTimesClick(int clickCount){
        for (int i=0; i < clickCount; i++) {
            notificationMessagePage.clickLinkClickHere();
        }
    }

    @Step("Check one of the messages show on click")
    public void checkNotificationMessage(String[] possibleMsgs){

        String msg = notificationMessagePage.getMessage();
        boolean isFound = false;
        for (String possibleMsg : possibleMsgs){
            if (msg.equals(possibleMsg)){
                isFound = true;
                break;
            }
        }
        Assert.assertTrue(isFound, "Message "+ msg +" not found in " + String.join("", possibleMsgs));
    }

}
