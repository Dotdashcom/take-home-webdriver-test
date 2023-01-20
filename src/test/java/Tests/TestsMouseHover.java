package Tests;

import Baseclass.BaseClass;
import Pages.MouseOverPage;
import org.testng.annotations.Test;

public class TestsMouseHover extends BaseClass {

    @Test
    public void T016_MouseOver_Testing() {
        MouseOverPage mouseOverPage = new MouseOverPage(driver);
        mouseOverPage.GoToMouseOver();
        mouseOverPage.MouseOver();
    }

}
