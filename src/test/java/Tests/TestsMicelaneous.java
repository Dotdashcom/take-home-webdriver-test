package Tests;

import Baseclass.BaseClass;
import Pages.MicelaneousPage;
import Pages.MouseOverPage;
import org.testng.annotations.Test;

public class TestsMicelaneous extends BaseClass {

    @Test
    public void T021_WindowTab_Testing() {
        MicelaneousPage micelaneousPage = new MicelaneousPage(driver);
        micelaneousPage.GoToWindows();
        micelaneousPage.OpenNewWindow();

    }
    @Test
    public void T022_CheckFlash_Testing() {
        MicelaneousPage micelaneousPage = new MicelaneousPage(driver);
        micelaneousPage.GoToNotifications();
        micelaneousPage.LoadNewMessage();
        micelaneousPage.AssertMessageDisplayed();

    }

}
