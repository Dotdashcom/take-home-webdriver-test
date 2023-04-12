package org.benjamin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotificationMessage extends PageBase {

    public void init() {
        super.init("http://localhost:7080/notification_message_rendered");
    }

    public boolean checkMessage() {
        String message;
        boolean exist = false;
        for(int i = 0; i < 100; i++){
            WebElement button = driver.findElement(By.cssSelector("a[href='/notification_message']"));
            button.click();
            message = driver.findElement(By.id("flash")).getText();
            message = message.split("\n")[0];
            if (message.equals("Action Successful")
                    || message.equals("Action unsuccessful, please try again")
                    || message.equals("Action Unsuccessful")){
                exist = true;
                break;
            }
        }

        return exist;
    }
}
