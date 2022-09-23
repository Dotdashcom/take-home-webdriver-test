package pages;

import core.AbstractWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationsPage extends AbstractWebPage {

    @FindBy(css = "div.example > p > a")
    protected WebElement clickHereLinkElm;

    @FindBy(css = "div#flash")
    protected WebElement flashMessageElm;

    public NotificationsPage(WebDriver driver) {
        super(driver);
    }

    public String clickAndGetNotificationMessage(){
        clickHereLinkElm.click();
        sleepInSeconds(1);

        if(flashMessageElm.getText() == null || flashMessageElm.getText().isEmpty()) {
            return "";
        }
        return flashMessageElm.getText();
    }
}