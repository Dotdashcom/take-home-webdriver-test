package src.test;

import org.testng.annotations.Test;
import src.main.pages.FramePage;
import src.main.utilities.Browser;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class FrameTest extends BaseTest {



    private FramePage framePage;

    @Test
    public void iframesTest() {
        framePage = Browser.open(baseURL + "iframe", FramePage.class);

        framePage.closeNotification();
        Browser.switchToIframe("mce_0_ifr");
        framePage.setText("Hello there.");
        assertEquals(framePage.getInnerText(), "Hello there.");
        Browser.switchToDefault();
    }

}
