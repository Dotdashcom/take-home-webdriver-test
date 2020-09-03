package com.alp.Tests;

import com.alp.utilities.BrowserFactory;
import com.alp.utilities.UtilWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NotificationMessage {

    /*
    Notification Message: http://localhost:7080/notification_message_rendered Test notification Message.
    */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/");

        WebElement link = driver.findElement(By.linkText("Notification Messages"));
        UtilWait.wait(1);
        link.click();

        driver.findElement(By.linkText("Click here")).click();
        UtilWait.wait(1);


        //    driver.close();

    }

}
