package pages;

import common.POBase;
import utils.BrowserUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class NotificationMessage extends POBase {
    public void verifyNotificationMessages(){
        WebDriver driver = BrowserUtil.GetDriver();
        String link = "Click here";
        for(int i=0; i<3; i++){
            getElement(By.linkText(link)).click();
            String message = getElement(By.xpath("//div[@class='flash notice']")).getText();
            Assert.assertTrue(isMessagePresent(message.toLowerCase()));
        }
    }

    private boolean isMessagePresent(String message){
        List<String> messages = Arrays.asList("Action Successful", "Action unsuccesful, please try again",
                "Action Unsuccessful");
        boolean present = false;
        for(int i=0; i<messages.size(); i++){
            if(message.trim().contains(messages.get(i).toLowerCase())){
                return true;
            }
        }
        return present;
    }
}
