

import org.testng.annotations.Test;
import org.testng.Assert;
import pageObject.DropDownPage;

public class Test06DropDown extends TestBase{
    
    @Test
    public void test06DropDown() throws InterruptedException{
        DropDownPage dropDownPage = new DropDownPage(webDriver);
        Assert.assertFalse(dropDownPage.isOptionSelected(1));
        dropDownPage.setOption(1);
        Assert.assertTrue(dropDownPage.isOptionSelected(1));
        Thread.sleep(1000);
        Assert.assertFalse(dropDownPage.isOptionSelected(2));
        dropDownPage.setOption(2);
        Assert.assertTrue(dropDownPage.isOptionSelected(2));
    }

}