package LocalHost.Tests;

import LocalHost.Pages.Drag_and_Drop_Page;
import static LocalHost.Utilities.BrowserUtils.*;
import org.testng.annotations.Test;

import java.awt.*;

public class Drag_and_Drop extends TestingBase{


    @Test(groups = {"DragDrop"})
    public void Drag_AtoB() throws AWTException {
        waitForPageToLoad(3);
        Drag_and_Drop_Page drag = new Drag_and_Drop_Page();
        drag.Drag_A_to_B();

    }

    @Test(groups = {"DragDrop"})
    public void Drag_BtoA(){
        waitForPageToLoad(3);
        Drag_and_Drop_Page drag = new Drag_and_Drop_Page();
        drag.Drag_B_to_A();
    }
}
