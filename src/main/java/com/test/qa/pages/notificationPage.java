package com.test.qa.pages;

import com.test.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class notificationPage extends TestBase{

    notificationPage nPage;

    @FindBy(linkText = "Notification Messages")
    WebElement notificationButton;

    @FindBy(linkText = "Click here")
    WebElement clickHereButton;
    @FindBy(xpath = "//div[@class='flash notice']")
    WebElement message;

    public notificationPage(){
        PageFactory.initElements(driver,this);
    }


    public void noMessage() {
        int i=0;
        while(i<5) {
            System.out.println("iteration# "+i);
            clickHereButton.click();

            wait.until(ExpectedConditions.elementToBeClickable(message));

            String msg = message.getText();
            String str[] = msg.split("\n");

            if(msg.contains("successful")) {
                Assert.assertEquals(str[0], "Action successful");
            }else if(msg.contains("unsuccessful")) {
                Assert.assertEquals(str[0], "Action unsuccesful, please try again");
            }

            i++;
        }
    }



}