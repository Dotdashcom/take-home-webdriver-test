package theInternet.tests;

import org.testng.annotations.Test;
import theInternet.pages.DynamicControls;

public class DynamicControlsTest extends TestBase {

    @Test
    public void dynamicControlTest(){
        DynamicControls dynamicControls = new DynamicControls(driver);
        dynamicControls.checkControls(driver);
    }
}
