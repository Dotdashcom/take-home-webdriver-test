package pageComponents;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NotificationAlert extends BasePage {
    private static final By MESSAGE = By.id("flash");

    public NotificationAlert(ChromeDriver driver) {
        super(driver);
    }

    public String getMessage() {
        return getText(MESSAGE, BasePage.ACTION_TIMEOUT).replace("×", "").trim();
    }
}
