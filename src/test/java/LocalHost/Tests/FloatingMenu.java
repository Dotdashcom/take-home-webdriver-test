package LocalHost.Tests;

import LocalHost.Pages.FloatingMenuPage;
import org.testng.annotations.Test;

public class FloatingMenu extends TestingBase {

    @Test(groups = "Floating")
    public void TestingMenu(){
        FloatingMenuPage page = new FloatingMenuPage();
        page.verifyMenu();
        page.ScrollMenu();
    }
}
