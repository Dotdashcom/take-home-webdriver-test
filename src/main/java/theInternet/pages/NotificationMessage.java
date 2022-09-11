package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class NotificationMessage {

    public NotificationMessage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Notification Messages")
    WebElement notification;

    @FindBy(linkText = "Click here")
    WebElement clickHere;

    @FindBy(className = "flash")
    WebElement message;

    public void clickNotification(){

        notification.click();
        List<String> messages = new ArrayList<>();
        messages.add("Action successful");
        messages.add("Action unsuccesful,please try again");
        messages.add("Action unsuccesful, please try again");

        clickHere.click();
        System.out.println(message.getText().replaceAll("×","").trim());
        Assert.assertTrue(messages.contains( message.getText().replaceAll("×","").trim()));
        clickHere.click();
        System.out.println(message.getText().replaceAll("×","").trim());
        Assert.assertTrue(messages.contains(message.getText().replaceAll("×","").trim()));




    }
}
