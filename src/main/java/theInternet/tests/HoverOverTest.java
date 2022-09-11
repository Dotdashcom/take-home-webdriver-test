package theInternet.tests;

import org.testng.annotations.Test;
import theInternet.pages.HoverOver;

public class HoverOverTest extends TestBase {

    @Test
    public void hoverOverTest(){
        HoverOver hoverOver = new HoverOver(driver);
        hoverOver.hoverOver(driver);
    }
}
