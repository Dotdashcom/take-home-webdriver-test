package pages;

import configuration.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePage extends BasePage {

    WebDriver driver;

    public NotificationMessagePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'Action unsuccesful, please try again')]")
    public WebElement tryAgainNotification;

    @FindBy(xpath = "//div[contains(text(),'Action successful')]")
    public WebElement successfulNotification;

    public void getNotificationMessages() {

        do {
            selectOptionByText("Click here");
        } while (!elementIsPresent(successfulNotification));

        do {
            selectOptionByText("Click here");
        } while (!elementIsPresent(tryAgainNotification));
    }
}
