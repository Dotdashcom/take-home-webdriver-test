package LocalHost.Tests;

import LocalHost.Pages.WindowsPage;
import org.testng.annotations.Test;

public class Windows extends TestingBase {

    @Test(groups = "Windows")
    public void TestWindowChange(){
        WindowsPage page = new WindowsPage();
        page.verifyNewWindow();
    }
}
