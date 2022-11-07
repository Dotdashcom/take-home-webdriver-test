import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NotificationCases extends Hooks {




    @Test(dataProvider = "Notification")
    public  void NewNotification(String text) throws InterruptedException {
        App.homePage.clickOptionFromMenu(HomeOptions.NotificationMessages.getOption());
        App.notificationPage.makeAppertext(text);
        // App.notificationPage.clickNewNotification();
        Assert.assertTrue(App.notificationPage.validateAlertText(text));
    }
}
