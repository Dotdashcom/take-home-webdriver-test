import pageObject.NotificationMessagePage;

import java.util.List;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test18NotificationMessage extends TestBase{
    NotificationMessagePage notificationMessagePage;

    @Test
    public void test18NotificationMessage() throws InterruptedException{
        notificationMessagePage = new NotificationMessagePage(webDriver);
        List<String> possibleOutputs = Arrays.asList("Action successful", "Action unsuccesful, please try again", "Action unsuccessful");
        for (int i=0;i<10;i++){
            notificationMessagePage.clickNewMessage();
            Thread.sleep(1000);
            String message = notificationMessagePage.getMessage();
            //Assert.assertTrue(possibleOutputs.contains(message));
            boolean hasMessage = false;
            for (String msg:possibleOutputs){
                if (message.contains(msg)){
                    hasMessage = true;
                }
            }
            Assert.assertTrue(hasMessage);
        }
        
    }
}