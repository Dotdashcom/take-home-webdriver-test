package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CheckBoxesPage;
import pages.HomePage;

public class CheckBoxesTest extends BaseTest{
    @Test
    public void verifyCheckBox() {
        HomePage homePage= new HomePage(driver);
        CheckBoxesPage checkBoxesPage = homePage.clickCheckBox();
        SoftAssert softAssert = new SoftAssert();
        checkBoxesPage.clickCheckBox1();
        softAssert.assertTrue(checkBoxesPage.verifyCheckBox1());
        checkBoxesPage.clickCheckBox2();
        softAssert.assertFalse(checkBoxesPage.verifyCheckBox2());
        softAssert.assertAll();
    }
}
