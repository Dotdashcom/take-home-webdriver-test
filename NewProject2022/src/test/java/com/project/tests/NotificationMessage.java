package com.project.tests;

import com.project.pages.ActionPage;
import com.project.utility.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessage {

    ActionPage message=new ActionPage();

    @Test
    public void MessageTest() {

        Driver.getDriver().get("http://localhost:7080/notification_message_rendered");

        Driver.getDriver().manage().window().maximize();

        message.clickButton.click();

        Assert.assertEquals(message.Message.getText(),"Action unsuccesful, please try again\n" +
                "×");

        message.clickButton.click();

        Assert.assertEquals(message.Message.getText(),"Action successful\n" +
                "×");

        Driver.closeDriver();
    }
}
