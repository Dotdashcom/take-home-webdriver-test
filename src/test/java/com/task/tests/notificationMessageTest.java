package com.task.tests;

import com.task.pages.notificationMessagePage;
import com.task.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class notificationMessageTest {

    notificationMessagePage notificationMessagePage = new notificationMessagePage();


    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://localhost:7080/notification_message_rendered");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.getDriver().close();
    }

    @Test
    public void notificationMessage() throws InterruptedException {

        for (int i = 1 ; i <= 10 ; i++) {

            notificationMessagePage.clickHere.click();

            if (notificationMessagePage.messages.equals("Action successful")) {
                Assert.assertEquals(notificationMessagePage.messages.getText(), "Action successful");
                System.out.println("Action Successful message : " + notificationMessagePage.messages.getText());
            } else if (notificationMessagePage.messages.equals("Action unsuccesful, please try again")) {
                Assert.assertEquals(notificationMessagePage.messages.getText(), "Action unsuccesful, please try again");
                System.out.println("Action unsuccesful, please try again message : " + notificationMessagePage.messages.getText());
            } else if (notificationMessagePage.messages.equals("Action Unsuccessful")) {
                Assert.assertEquals(notificationMessagePage.messages.getText(), "Action Unsuccessful");
                System.out.println("Action Unsuccessful message : " + notificationMessagePage.messages.getText());
            }
            System.out.println("Message " + i + ": " + notificationMessagePage.messages.getText() );
            Thread.sleep(1000);
        }
    }




}
