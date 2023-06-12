package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePage {

    private WebDriver driver;

    public NotificationMessagePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Click here']")
    private WebElement clickHereButton;

    @FindBy(xpath = "//div[@id='flash']")
    private WebElement messageField;

    String message1 = "Action unsuccesful, please try again";
    String message2 = "Action successful";

    public boolean clickButtonMultipleTimes() {
        int firstMessageCount = 0;
        int secondMessageCount = 0;
        for (int i = 0; i < 30; i++) {
            clickHereButton.click();
            String actualMessage = messageField.getText();
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

}
