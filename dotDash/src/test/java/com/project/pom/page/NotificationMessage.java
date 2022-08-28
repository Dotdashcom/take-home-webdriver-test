package com.project.pom.page;

import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotificationMessage extends Base {

    By clickHere = By.xpath("//div[@class='example']//a[contains(@href, '/noti')]");
    By notificationMesage = By.xpath("//div[@id='flash-messages']/div[@id='flash']");

    public NotificationMessage(WebDriver driver) {
        super(driver);
    }

    public Boolean notification(){
        String[] messages = {"Action Successful", "Action Unsuccessful", "Action unsuccesful, please try again"};
        int attempts = 3;
        boolean flag = false;
        for (int i = 0; i< attempts; i++){
            click(clickHere);
            for (String mesages : messages){
                if (getText(notificationMesage).contains(mesages)){
                    flag = true;
                }
            }
        }
        return flag;
    }
}
