package LocalHost.Tests;

import LocalHost.Pages.NotificationMessagePage;
import org.testng.annotations.Test;

public class NotificationMessages extends TestingBase {


    @Test(groups = "Message")
    public void test1() {
        NotificationMessagePage page; page = new NotificationMessagePage();
        page.testMessage1();
    }
}
