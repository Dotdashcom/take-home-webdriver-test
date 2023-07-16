package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.DropdownPage;
import testComponents.BaseTest;

public class DropdownTest extends BaseTest {

    @Test
        public void dropdownmenu() throws InterruptedException {
        DropdownPage dropdown = new DropdownPage(driver);
        dropdown.goTo();
        dropdown.selectOption1();
        Assert.assertEquals(dropdown.getTextOption1(),"Option 1");
        dropdown.selectOption2();
        Assert.assertEquals(dropdown.getTextOption2(),"Option 2");
    }



}
