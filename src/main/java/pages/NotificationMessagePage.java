package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationMessagePage extends BasePage {

    @FindBy(css = "div.example > p > a")
    protected WebElement clickHereLink;

    @FindBy(css = "div#flash")
    protected WebElement flashMessage;

    public NotificationMessagePage(WebDriver driver) {
        super(driver);
    }

    public boolean notificationMessage() {
        for(int i = 0; i < 6; i++) {
            clickHereLink.click();
        }
        if(flashMessage.getText().contains("Action successful")
                || flashMessage.getText().contains("Action unsuccesful, please try again")) {
            return true;
        } else if (flashMessage.getText().contains("Action Unsuccessful")) {
            return true;
        } else {
            return false;
        }
    }
}
