package tests;

import model.CheckboxesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class CheckBoxesTest  extends BaseTest {

    @Test
    public void testSelectCheckboxOne() {
        boolean checkboxOneIsSelected =  new CheckboxesPage(getDriver())
                .getCheckboxesPage()
                .selectCheckboxOne()
                .isCheckboxOneSelected();

        Assert.assertTrue(checkboxOneIsSelected);
    }

    @Test
    public void testSelectCheckboxTwo() {
         boolean checkboxTwoIsSelected =  new CheckboxesPage(getDriver())
                .getCheckboxesPage()
                .selectCheckboxTwo()
                .isCheckboxTwoSelected();

        Assert.assertTrue(checkboxTwoIsSelected);
    }

    @Test
    public void testSelectBothCheckboxes() {
        int expectedResult = 2;

        int actualResult = new CheckboxesPage(getDriver())
                .getCheckboxesPage()
                .selectCheckboxOne()
                .selectCheckboxTwo()
                .getSelectedCheckboxListSize();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testDeselectBothCheckboxes() {
        int expectedResult = 0;

        int actualResult = new CheckboxesPage(getDriver())
                .getCheckboxesPage()
                .deselectCheckboxOne()
                .deselectCheckboxTwo()
                .getSelectedCheckboxListSize();

        Assert.assertEquals(actualResult, expectedResult);
    }
}