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
        WebElement ClickLink;
        //Check until "Action successful"  Notification observed
        do  {
            ClickLink = driver.findElement(By.linkText("Click here"));
            ClickLink.click();
            Thread.sleep(1000);
            System.out.println(driver.findElement(By.xpath("//div[@id='flash']")).getText());
        } while(!driver.findElement(By.xpath("//div[@id='flash']")).getText().contains("Action successful"));

        //Check until "Action unsuccesful, please try again"  Notification observed
        do {
            ClickLink = driver.findElement(By.linkText("Click here"));
            ClickLink.click();
            Thread.sleep(1000);
            System.out.println(driver.findElement(By.xpath("//div[@id='flash']")).getText());
        } while(!driver.findElement(By.xpath("//div[@id='flash']")).getText().contains("Action unsuccesful, please try again"));
    }
}