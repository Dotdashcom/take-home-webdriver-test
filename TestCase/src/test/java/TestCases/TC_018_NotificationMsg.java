package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.Callable;

public class TC_018_NotificationMsg extends BaseClass {
    @Test (priority=18) // Test case for Notification Message
    public void NotificationMsg() throws InterruptedException {
        //Launching Notification Url
        driver.get(BaseUrl + "notification_message_rendered");
        //Inspecting WebElement to Click on 'ClicK Here' link
        WebElement ClickLink = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
        //Clicking on Click Here link to get Action Successful Message
        ClickLink.click();
        Thread.sleep(3000);
        //inspecting Message Of Action
        WebElement ActionMsg = driver.findElement(By.id("flash"));
        System.out.println(ActionMsg.getText());
        //Assertion for Message Success
        Assert.assertTrue(driver.getPageSource().contains("Action successful"));
    }
}