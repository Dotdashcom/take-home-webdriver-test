package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Test18NotificationMessage extends chromedriver {

    @Test
    public void Test18NotificationMessage() {
        String url = "http://localhost:7080/notification_message_rendered";
        driver.get(url);

        By clickHereLabelXpath = By.xpath("//div[@class='example']/descendant::a[text()='Click here']");
        By notificationXpath = By.xpath("//div[@id='flash-messages']/div[@id='flash']");

        //possible notification texts
        String[] possibleMessages = {
               "Action Successful",
               "Action unsuccesful, please try again",
                "Action Unsuccessful"
        };

        driver.findElement(clickHereLabelXpath).click();
        //get notification text
        String notificationText = driver.findElement(notificationXpath).getText();
        //loop through possible texts to check if current one is in this list
        Boolean notificationFlag = false;
        for (String possibleMessage: possibleMessages) {
            if (notificationText.contains(possibleMessage)) {
                notificationFlag = true;
            }
        }
        //assert that it's one of the texts
        Assert.assertTrue(notificationFlag);
    }

}