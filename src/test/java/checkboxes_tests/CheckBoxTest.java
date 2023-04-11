package checkboxes_tests;

import base.Base;
import org.testng.annotations.Test;
import page_object_model.checkboxes_page.CheckboxesPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckBoxTest extends Base {
    // test to verify that the checkbox one is selected (positive test)
    @Test
    public void testCheckboxOneIsSelected() {
        CheckboxesPage checkboxesPage = new CheckboxesPage();
        checkboxesPage.clickCheckBoxesOne();
        assertTrue(CheckboxesPage.checkboxes1.isSelected());
    }

    //test to verify that the checkbox two is selected(positive test)
    @Test
    public void testCheckboxTwoIsSelected() {
        CheckboxesPage checkboxesPage = new CheckboxesPage();
        assertTrue(CheckboxesPage.checkboxes2.isSelected());
    }// test to verify that the checkbox one is not selected (positive test)

    @Test
    public void testCheckboxOneIsNotSelected() {
        CheckboxesPage checkboxesPage = new CheckboxesPage();
        assertFalse(CheckboxesPage.checkboxes1.isSelected());

    }

    //test to verify that the checkbox two is not selected(positive test)
    @Test
    public void testCheckboxTwoIsNotSelected() {
        CheckboxesPage checkboxesPage = new CheckboxesPage();
        checkboxesPage.clickCheckBoxesTwo();
        assertFalse(CheckboxesPage.checkboxes2.isSelected());
    }

    /*
     * test where both checkboxes are selected
     * */
    @Test
    public void testBothCheckBoxesAreSelected() {
        CheckboxesPage checkboxesPage = new CheckboxesPage();
        checkboxesPage.clickCheckBoxesOne();
        assertTrue(CheckboxesPage.checkboxes1.isSelected());
        assertTrue(CheckboxesPage.checkboxes2.isSelected());
    }

    /*
     * test where both checkboxes  are  not selected*/
    @Test
    public void testBothCheckBoxesAreUnSelected() {
        CheckboxesPage checkboxesPage = new CheckboxesPage();
        checkboxesPage.clickCheckBoxesTwo();
        assertFalse(CheckboxesPage.checkboxes1.isSelected());
        assertFalse(CheckboxesPage.checkboxes2.isSelected());
    }
}
