package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.CheckboxPage;
import theinternet.pages.HomePage;

public class CheckboxPageTests extends BaseTest{
    CheckboxPage checkboxPage;
    @BeforeClass
    public void initialize() throws InterruptedException {
        homePage.navigateToCheckBoxPage();
        checkboxPage= new CheckboxPage();
        Thread.sleep(2000);
    }
    @Test(priority = 0)
    public void validatePageLanding(){
        Assert.assertTrue(checkboxPage.checkboxesPageLanding(), "Checkbox page not loaded");
    }

    @Test(priority = 1)
    public void validateCheckbox1() throws InterruptedException {
        String checkBox = "1";
        checkboxPage.selectCheckBox(checkBox);
        Assert.assertTrue(checkboxPage.isCheckBoxSelected(checkBox), "Checkbox " + checkBox + " is not selected");
    }

    @Test(priority = 2)
    public void validateCheckbox2() throws InterruptedException {
        String checkBox = "2";
        checkboxPage.selectCheckBox(checkBox);
        Assert.assertFalse(checkboxPage.isCheckBoxSelected(checkBox), "Checkbox " + checkBox + " is selected");
    }
}
