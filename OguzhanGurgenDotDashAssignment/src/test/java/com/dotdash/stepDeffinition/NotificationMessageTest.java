package com.dotdash.stepDeffinition;

import com.dotdash.utillities.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class NotificationMessageTest {

    @Before
    public void setup() {
        Driver.getDriver().get("http://localhost:7080/notification_message_rendered");

    }

    @After
    public void teardown() {

        Driver.closeDriver();
    }

    @Test
    public void notificationMessage() throws InterruptedException {

        //created an array and stored messages shows up as notification.
        ArrayList<String> answers = new ArrayList<String>();
        answers.add("Action unsuccesful, please try again");
        answers.add("Action successful");

        //locator of button and clicked it.
        WebElement clickHereButton = Driver.getDriver().findElement(By.xpath("//a[@href='/notification_message']"));
        clickHereButton.click();

        //locator of button and clicked it.
        clickHereButton = Driver.getDriver().findElement(By.xpath("//a[@href='/notification_message']"));
        clickHereButton.click();

        //locator of button and clicked it.
         clickHereButton = Driver.getDriver().findElement(By.xpath("//a[@href='/notification_message']"));
         clickHereButton.click();


         //locator of message box
         WebElement messageBox = Driver.getDriver().findElement(By.id("flash"));

         //shown message as String
         String message = messageBox.getText();
         System.out.println(message);

      //Checking message is shown is match with expected messages.
        Assert.assertTrue(message.contains(answers.get(0).toString()) || message.contains(answers.get(1).toString()));


    }
}
