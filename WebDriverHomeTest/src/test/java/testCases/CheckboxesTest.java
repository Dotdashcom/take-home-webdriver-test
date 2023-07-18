package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.CheckboxesPage;
import testComponents.BaseTest;


public class CheckboxesTest extends BaseTest {

    @Test
    public void checkbox() {
        CheckboxesPage checkbox=new CheckboxesPage(driver);
        checkbox.goTo();
        checkbox.checkCheckbox1();
        Assert.assertTrue(checkbox.isCheckbox1Selected());
        checkbox.uncheckCheckbox2();
        Assert.assertFalse(checkbox.isCheckbox2Selected());
    }

}
