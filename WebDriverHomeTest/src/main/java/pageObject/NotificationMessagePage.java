package pageObject;

import base.CommonApi;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePage extends CommonApi {
    WebDriver driver;
    public NotificationMessagePage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[text()='Click here']")
    WebElement clickButton;
    @FindBy(xpath = "//*[@id='flash']")
    WebElement message;

    public void clickOnButton(){
        clickButton.click();
    }

    String message1 = "Action unsuccesful, please try again";
    String message2 = "Action successful";
    public boolean clickButtonManyTimes() {
        int firstMessageCount = 0;
        int secondMessageCount = 0;
        for (int i = 0; i < 10; i++) {
            clickButton.click();
            String actualMessage = message.getText();
            if (actualMessage.contains(message1)) {
                firstMessageCount++;

            } else if (actualMessage.contains(message2)) {
                secondMessageCount++;
            }
        }
        if (firstMessageCount > 0 && secondMessageCount > 0) {
            return true;
        }
        return false;
    }




    public void goTo(){
        driver.get("http://localhost:7080/notification_message_rendered");
    }

}
