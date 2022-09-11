package theInternet.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import theInternet.pages.CheckBoxes;

public class checkBoxTest extends TestBase {


    @Test
    public void clickBoxTest() throws InterruptedException {
        CheckBoxes checkBoxes = new CheckBoxes(driver);
        checkBoxes.checkBoxClick();
        String actualHeader= checkBoxes.getHeader();
        Assert.assertEquals(actualHeader,"Checkboxes");

}
}
