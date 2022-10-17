package Assignment;

import Pages.NotificationMessagePage;
import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotificationMessage extends TestBase {
    // Since I was getting StaleElementExp I had to use Page Object Module to avoid this exception for this particular test

    @Test
    public void notificationMessageTest(){

        driver.get(baseUrl + "/notification_message_rendered");

        NotificationMessagePage page = new NotificationMessagePage(driver);



        String[] possibleMessages = {"Action unsuccesful, please try again" , "Action successful" , "Action Unsuccessful"};


        for (int i = 0; i < 10 ; i++) {
            page.clickHereLink.click();

            String actualText  = page.notificationMessage.getText();
            Assert.assertTrue(Arrays.asList(possibleMessages).contains(actualText.substring(0,actualText.lastIndexOf('\n'))),"Notification Message Test FAILED!");
        }



    }
}
