import org.openqa.selenium.*;

import java.util.ArrayList;

public class NotificationMsgPage extends BasePage {
    private String path = "/notification_message_rendered";

    private By newNotifLinkBy = By.xpath("//a[contains(text(), \"Click here\")]");
    private By notifBy = By.xpath("//div[@id=\"flash\"]");

    // There's a typo in the message "Action unsuccesful", I'm assuming it should use what the page actually uses.
    private String[] validNotifMessages = {"Action successful", "Action unsuccesful, please try again", "Action unsuccessful"};

    NotificationMsgPage(WebDriver webdriver) {
        driver = webdriver;
    }

    public String getUrl() {
        String url = getBaseUrl() + path;
        return url;
    }

    public void clickMessageLink() {
        driver.findElement(newNotifLinkBy).click();
    }

    public String getNotifMsg() {
        String notifText = driver.findElement(notifBy).getText().trim();
        // Remove the x at the end
        notifText = notifText.substring(0, notifText.length()-2);
        return notifText;
    }

    public boolean validNotifMessage(String notifMsg) {
        for (String validMsg : validNotifMessages) {
            if (notifMsg.equals(validMsg))
                return true;
        }
        return false;
    }
}
