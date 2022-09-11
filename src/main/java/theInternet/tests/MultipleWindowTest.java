package theInternet.tests;

import org.testng.annotations.Test;
import theInternet.pages.MultipleWindow;

public class MultipleWindowTest extends TestBase {

    @Test
    public void multipleWindowTest(){
        MultipleWindow multipleWindow = new MultipleWindow(driver);
        multipleWindow.clickHere(driver);
    }
}
