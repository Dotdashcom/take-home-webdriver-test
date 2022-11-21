package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class NotificationMessage extends BasePage{

    By clickHere= By.xpath("//*[text()='Click here']");

    public boolean notificationMessagesDisplayed()
    {
        boolean notificationDisplayed=false;
        String content;
        String message;
        Utility.wait(driver.findElement(clickHere));
            driver.findElement(clickHere).click();
            String script = "return window.getComputedStyle(document.querySelector('#flash'),':before').getPropertyValue('content')";
            JavascriptExecutor js = (JavascriptExecutor)driver;
             content = (String) js.executeScript(script);

             for(int i=0; i<3; i++){
                 driver.findElement(clickHere).click();
                 String script1 = "return window.getComputedStyle(document.querySelector('#flash'),':before').getPropertyValue('content')";
                 JavascriptExecutor js1 = (JavascriptExecutor)driver;
                 message = (String) js1.executeScript(script);
                 if(content.contains(message))
                 {
                     continue;
                 }
                 else{
                     notificationDisplayed=true;
                     break;
                 }
        }
            return notificationDisplayed;
    }
}
