package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.DropdownPage;

public class DropdownPageTests extends BaseTest{
    DropdownPage dropdownPage;
    @BeforeClass
    public void initialize() throws InterruptedException {
        homePage.navigateToDropdownPage();
        dropdownPage = new DropdownPage();
        Thread.sleep(2000);
    }
    @Test(priority = 0)
    public void testPageLanding() throws InterruptedException {
        Assert.assertTrue(dropdownPage.validatePageLanding());
    }

    @Test(priority = 1)
    public void testSelectOption1() throws InterruptedException {
       String myOption = "Option 1";
       dropdownPage.selectDropDown(myOption);
       Thread.sleep(2000);
       String actual = dropdownPage.getDropDownText();
       Assert.assertEquals(actual, myOption, "Select " + myOption + " failed");
    }

    @Test(priority = 2)
    public void testSelectOption2() throws InterruptedException {
        String myOption = "Option 2";
        dropdownPage.selectDropDown(myOption);
        Thread.sleep(2000);
        String actual = dropdownPage.getDropDownText();
        Assert.assertEquals(actual, myOption, "Select " + myOption + " failed");
    }
}
