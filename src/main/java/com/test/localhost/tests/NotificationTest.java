package com.test.localhost.tests;

import com.test.localhost.pages.NotificationPage;
import com.test.localhost.utils.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class NotificationTest extends TestBase {

    @Test
    public void notificationMsgTest(){
        NotificationPage notificationPage=new NotificationPage(driver);
        notificationPage.clickButton();
        notificationPage.clickHere();
        List<String> messages=new ArrayList<>();
        String message1="Action successful";
        String message2="Action unsuccessful";
        String message3="Action unsuccessful, please try again";
        messages.add(message1);
        messages.add(message2);
        messages.add(message3);

        for(int i=0;i<10;i++){
            notificationPage.clickHere();
            for (int j=0;j< messages.size();j++){
                if(messages.get(j).equals(notificationPage.validateMessage())){
                    Assert.assertEquals(messages.get(j),notificationPage.validateMessage());
                    break;
                }
            }
        }


    }


}
