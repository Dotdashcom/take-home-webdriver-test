package org.example;

import Resources.driverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Mouseclick;
import pageObjects.Notification;

import java.io.IOException;

public class Notificatio extends driverConfig {
    public WebDriver driver;

    @BeforeTest
    public void startdriver() throws IOException {
        driver = invokedriver();
        driver.get(baseUrl + "notification_message_rendered");

    }

    @Test
    public void Notify() throws InterruptedException {

        Notification n = new Notification(driver);

        String s1, s2, s3;

        s1 = "Action successful";
        s2 = "Action unsuccesful, please try again";
        s3 = "Action Unsuccessful";


        for (int i=0;i<5;i++)
        {
            n.ClickonLink().click();

            String s = n.flsmsg().getText();

            if (s.contains(s1) | s.contains(s2) | s.contains(s3)) {
                System.out.println("The text is verified");
            }
        }


    }


    @AfterTest
    public void closebrowser() throws InterruptedException {

        driver.manage().deleteAllCookies();
        driver.close();
    }

}
