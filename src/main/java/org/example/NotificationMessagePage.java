package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class NotificationMessagePage extends BasePage{

    protected WebDriver driver;

    By notificationPage = By.cssSelector("[href='\\/notification_message']");
    By clickhereOption = By.cssSelector("[href='\\/notification_message']");

    By notificationPageText = By.cssSelector("div#flash");

    public NotificationMessagePage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getNotificationPage(){
        return driver.findElement(notificationPage);
    }
    public WebElement getClickOption(){
        return driver.findElement(clickhereOption);
    }
    public String getNotificationMessage(){
        return driver.findElement(notificationPageText).getAttribute("innerText");
    }

    public void notificationMessageAction(){

        getNotificationPage().click();
        Random rd = new Random();
        int i = 0;
        while (i < rd.nextInt(10)+2){
            getClickOption().click();
            i++;
        }
    }

    public String[] notificationMessageArray(){
        String[] messages = {" Action successful"," Action unsuccesful, please try again"};
        return messages;
    }

    public boolean arrayContainsString(String[] array, String search) {
        for (String element : array) {
            if (search.contains(element)) {
                return true;
            }
        }
        return false;
    }
}
