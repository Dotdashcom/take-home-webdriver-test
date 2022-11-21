package com.tests.pages;

import com.tests.util.DriverTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationMessagePage extends BasePage{



    @FindBy(xpath = "//a[.='Click here']")
    private WebElement linkInput;

    @FindBy(xpath = "//div[@class='flash notice']")
    private WebElement messageInput;




    @BeforeClass
    public static void setUp(){
        DriverTest.getDriver().get("http://localhost:7080/notification_message_rendered");
    }


    @Test
    public void clickHereLinkMultipleTimes(){
        waitForVisibilityOf(linkInput);
          int count = 0;
           while (count <= 3){
               linkInput.click();
               String successMessage = messageInput.getText();
               System.out.println("-> Success message is: " + successMessage);
               Assert.assertTrue("!!! Success message does not contains the text !!!",successMessage.contains("Action unsuccesful, please try again") || successMessage.contains("Action successful") );
               count++;
           }
    }

    @AfterClass
    public static void tearDown() {
        DriverTest.getDriver().close();
    }
}
