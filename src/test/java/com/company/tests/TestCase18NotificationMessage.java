package com.company.tests;


import com.company.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 Test clicks on the Click Here link a multiple times.
 Test asserts that one of the “Action Successful”, “Action unsuccessful, please try again” and “Action Unsuccessful” messages show on click.
 */
public class TestCase18NotificationMessage {

    @Test
    public void notificationMessage() {

        Driver.getDriver().get("http://localhost:7080/notification_message_rendered");

        WebElement clickHere = Driver.getDriver().findElement(By.xpath("//*[@id='content']/div/p/a"));
        clickHere.click();

        WebElement notificationMessage = Driver.getDriver().findElement(By.xpath("//*[@id='flash']/text()[1]"));

        notificationMessage.getText();
        Assert.assertEquals(notificationMessage.getText(),"Action Successful","Message \"Action Successful\" did not matched!");
        Assert.assertEquals(notificationMessage.getText(),"Action unsuccessful, please try again","Message Action unsuccessful, please try againdid not matched!");
        Assert.assertEquals(notificationMessage.getText(),"Action Unsuccessful","Message Action Unsuccessful did not matched!");




        Driver.closeDriver();
    }
}
