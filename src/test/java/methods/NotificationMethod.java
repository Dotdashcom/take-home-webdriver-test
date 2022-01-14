package methods;

import model.NotificationPage;

public class NotificationMethod extends GeneralTestMethod{
    private final String notificationTabURL = "http://localhost:7080/notification_message_rendered";
    NotificationPage notificationPage;

    public void startNotificationTest() {
        driver.get(notificationTabURL);
        notificationPage = new NotificationPage(driver);
        notificationPage.clickComponent().click();
    }

    public String getNotification() {
        return notificationPage.notificationComponent().getText();
    }

}
