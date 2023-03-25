package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CheckBoxesPage;

public class CheckBoxesPageTest extends TestConfiguration {

    @Test
    @Parameters({"baseUrl", "checkBoxesUrl"})
    public void checkBoxes_Test1(String baseUrl, String checkBoxesUrl) {

        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        checkBoxesPage.goToUrl(baseUrl , checkBoxesUrl);

        checkBoxesPage.resetCheckBoxes();

        //check and uncheck checkbox1
        checkBoxesPage.clickCheckBox1();
        Assert.assertTrue(checkBoxesPage.isCheckBox1Selected());
        checkBoxesPage.clickCheckBox1();
        Assert.assertFalse(checkBoxesPage.isCheckBox1Selected());

    }

    @Test
    @Parameters({"baseUrl", "checkBoxesUrl"})
    public void checkBoxes_Test2(String baseUrl, String checkBoxesUrl) {

        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        checkBoxesPage.goToUrl(baseUrl , checkBoxesUrl);

        checkBoxesPage.resetCheckBoxes();

        //check and uncheck checkbox2
        checkBoxesPage.clickCheckBox2();
        Assert.assertTrue(checkBoxesPage.isCheckBox2Selected());
        checkBoxesPage.clickCheckBox2();
        Assert.assertFalse(checkBoxesPage.isCheckBox2Selected());
    }

}
