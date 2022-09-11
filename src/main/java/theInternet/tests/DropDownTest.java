package theInternet.tests;

import org.testng.annotations.Test;
import theInternet.pages.DropDown;

public class DropDownTest extends TestBase {

    @Test
    public void dropDownTest(){
        DropDown dropdown = new DropDown(driver);
        dropdown.dropDown();
    }
}
