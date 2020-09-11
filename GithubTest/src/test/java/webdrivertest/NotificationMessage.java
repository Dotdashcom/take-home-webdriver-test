package webdrivertest;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessage extends Base {
    WebDriver driver;

    @Test
    public void notificationMessage(){
        driver = getDriver();

        driver.get("http://localhost:7080/notification_message_rendered");

        driver.findElement(By.xpath("//a[contains(text(),'Click here')]")).click();
        WebElement click= driver.findElement(By.xpath("//div[@id='flash']"));
        String actual = click.getText();
        String expected = "Action successful\n" +
                "×";
        System.out.println(actual);
        Assert.assertEquals(actual, expected);





    }

}
