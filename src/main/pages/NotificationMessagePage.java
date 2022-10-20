package src.main.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
public class NotificationMessagePage extends BasePage {
    public NotificationMessagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div#content > div.example > p > a")
    private WebElement clickHereLink;

    @FindBy(css = "div[class='flash notice']")
    private WebElement flashMessage;

    public void loadNewMessage() {
        clickHereLink.click();
    }

    public boolean isFlashMessageExpected() {
        return getFlashMessage().contains("Action unsuccesful, please try again") ||
                getFlashMessage().contains("Action successful") ||
                getFlashMessage().contains("Action unsuccessful");
    }

    private String getFlashMessage() {
        return flashMessage.getText();
    }
}
