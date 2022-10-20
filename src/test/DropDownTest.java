package src.test;

import org.testng.annotations.Test;
import src.main.pages.CheckBoxesPage;
import src.main.utilities.Browser;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class DropDownTest extends BaseTest {



    private CheckBoxesPage chxBoxPage;

    @Test
    public void checkBoxTest() {
        chxBoxPage = Browser.open( baseURL + "checkboxes", CheckBoxesPage.class);
        chxBoxPage.selectCheckBoxOne();
        assertTrue(chxBoxPage.isCheckboxOneSelected());
        chxBoxPage.selectCheckBoxTwo();
        assertFalse(chxBoxPage.isCheckboxTwoSelected());
    }

}
