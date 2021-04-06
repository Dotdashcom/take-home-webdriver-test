package TakeHome.tests;

import TakeHome.pages.WindowsPage;
import TakeHome.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTest extends TestBase {

    @Test(groups = "Windows")
    public void TestWindowChange(){
        WindowsPage page = new WindowsPage();
        page.switchToNewWindow();
        String handle= Driver.get().getTitle();
        Assert.assertEquals(handle,"New Window", "Switched window title does not match");
    }
}
