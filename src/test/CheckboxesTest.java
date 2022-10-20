package src.test;
import org.testng.annotations.*;
import src.main.pages.CheckBoxesPage;
import src.main.utilities.Browser;
import src.main.utilities.CommonMethods;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class CheckboxesTest extends BaseTest {



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
