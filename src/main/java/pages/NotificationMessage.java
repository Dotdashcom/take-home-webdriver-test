package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Utils.BrowserUtils;

public class NotificationMessage {
    public NotificationMessage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[.='Click here']")
    WebElement button;

    @FindBy(css = "div[id='flash']")
    WebElement message;

    public boolean click1(WebDriver driver) {
        BrowserUtils.clickJS(driver, button);
        while (message.getText().isEmpty()) {
        }
        String messageText = message.getText();
        if (messageText.contains("Action Successful") ||
                messageText.contains("Action unsuccessful, please try again") ||
                messageText.contains("Action Unsuccessful")) {
        }
        return true;
    }
}
