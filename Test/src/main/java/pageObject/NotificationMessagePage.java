package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotificationMessagePage {
    WebDriver webDriver;
    String getMessageButtonXpath = "//a[text()='Click here']";
    String messageXpath = "//div[@id='flash']";
    String notificationMessagePageurl = "http://localhost:7080/notification_message_rendered";
    
    public NotificationMessagePage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get(notificationMessagePageurl);
    }

    public void clickNewMessage(){
        webDriver.findElement(By.xpath(getMessageButtonXpath)).click();
    }

    public String getMessage(){
        return webDriver.findElement(By.xpath(messageXpath)).getText();
    }

}
