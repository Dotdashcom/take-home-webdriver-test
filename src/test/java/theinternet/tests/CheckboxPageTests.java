package theinternet.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theinternet.pages.CheckboxPage;
import theinternet.pages.Navigation;

public class CheckboxPageTests extends BaseTest{
    private CheckboxPage checkboxPage;
    private Navigation navigation;

    @BeforeClass
    private void initialize(){
        checkboxPage = new CheckboxPage();
        navigation = new Navigation();
    }
    @Test(priority = 0)
    public void navigateToCheckboxPage(){
        Assert.assertTrue(navigation.navigateToCheckBoxPage());
    }
    @Test(priority = 1)
    public void validatePageLanding(){
        Assert.assertTrue(checkboxPage.checkboxesPageLanding());
    }

    @Test(priority = 2)
    public void validateCheckbox1() throws InterruptedException {
        Assert.assertTrue(checkboxPage.validateCheckbox1());
    }

    @Test(priority = 3)
    public void validateCheckbox2() throws InterruptedException {
        Assert.assertTrue(checkboxPage.validateCheckbox2());
    }
}
