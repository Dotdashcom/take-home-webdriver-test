package com.dotdash;

import org.junit.Test;
import org.openqa.selenium.By;

public class Test18NotificationMessage extends BaseMethod{

    int ins;

    @Test
    public void NotificationMessage() throws InterruptedException {
        driver.get("http://localhost:7080/notification_message_rendered");

        for (int i=0; i<ins; i++){
            driver.findElement(By.xpath("//a[@href =\"/notification_message\"]")).click();
            Thread.sleep(2000);
        }


    }
}
