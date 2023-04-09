package com.internet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationPage extends BasePage{

    @FindBy(id = "flash")
    private WebElement messageFlash;

    @FindBy(linkText = "Click here")
    private WebElement clickHere;


    public String returnMessage(){
        return messageFlash.getText().trim();
    }



    public Integer atleastOnce(){
        int msg1 = 1;
        int msg2 = 1;
        while (msg1 <2 && msg2<2) { // When it reaches to 2 means it displayed at least once
            clickHere.click();
            if (returnMessage().contains("Action successful")) {
                msg1++;
            } else if (returnMessage().contains("Action unsuccesful, please try again")) {
                msg2++;
            }
        }
        return (msg1+msg2);
    }

    }

