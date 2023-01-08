package tests;

import model.CheckboxesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class CheckBoxesTest  extends BaseTest {

    @Test
    public void testSelectCheckboxOne() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(getDriver()).getCheckboxesPage();
        if(checkboxesPage.isCheckboxOneSelected()) {
            checkboxesPage.clickCheckboxOne();
        }
        boolean checkboxOneIsSelected =  checkboxesPage
                .clickCheckboxOne()
                .isCheckboxOneSelected();

        Assert.assertTrue(checkboxOneIsSelected);
    }

    @Test
    public void testSelectCheckboxTwo() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(getDriver()).getCheckboxesPage();
        if(checkboxesPage.isCheckboxTwoSelected()) {
            checkboxesPage.clickCheckboxTwo();
        }
        boolean checkboxTwoIsSelected =  checkboxesPage
                .clickCheckboxTwo()
                .isCheckboxTwoSelected();

        Assert.assertTrue(checkboxTwoIsSelected);
    }

    @Test
    public void testSelectBothCheckboxes() {
        int expectedResult = 2;
        CheckboxesPage checkboxesPage = new CheckboxesPage(getDriver()).getCheckboxesPage();
        if(checkboxesPage.isCheckboxOneSelected()) {
            checkboxesPage.clickCheckboxOne();
        }
        if(checkboxesPage.isCheckboxTwoSelected()) {
            checkboxesPage.clickCheckboxTwo();
        }
        int actualResult = checkboxesPage
                .clickCheckboxOne()
                .clickCheckboxTwo()
                .getSelectedCheckboxListSize();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testUnselectBothCheckboxes() {
        int expectedResult = 0;
        CheckboxesPage checkboxesPage = new CheckboxesPage(getDriver()).getCheckboxesPage();
        if(!checkboxesPage.isCheckboxOneSelected()) {
            checkboxesPage.clickCheckboxOne();
        }
        if(!checkboxesPage.isCheckboxTwoSelected()) {
            checkboxesPage.clickCheckboxTwo();
        }
        int actualResult = checkboxesPage
                .clickCheckboxOne()
                .clickCheckboxTwo()
                .getSelectedCheckboxListSize();

        Assert.assertEquals(actualResult, expectedResult);
    }
}