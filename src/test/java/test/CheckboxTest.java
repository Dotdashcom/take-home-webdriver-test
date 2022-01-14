package test;

import methods.CheckboxPageMethod;
import model.CheckboxPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

// tests for two checkboxes, checkbox1 should be checked and checkbox2 should be unchecked, hence the tests
// should be passed.
public class CheckboxTest extends CheckboxPageMethod {

    @Test
    public void checkbox1Test() {
        startCheckboxTest("1");
        assertTrue(isBoxChecked(),"Checkbox1 is unchecked");
    }
    @Test
    public void checkbox2Test() {
        startCheckboxTest("2");
        assertFalse(isBoxChecked(),"Checkbox2 is checked");
    }
}
