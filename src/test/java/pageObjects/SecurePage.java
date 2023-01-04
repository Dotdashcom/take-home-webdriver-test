package pageObjects;

import base.Page;
import org.openqa.selenium.chrome.ChromeDriver;
import pageComponents.NotificationAlert;

public class SecurePage extends Page {
    private NotificationAlert notificationAlert;

    public SecurePage(ChromeDriver driver) {
        super(driver);
        notificationAlert = new NotificationAlert(driver);
    }

    public String getSuccessLoginMessage() {
        return notificationAlert.getMessage();
    }
}
