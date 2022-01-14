package test;

import methods.DropdownMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


// two tests for dropdown selection 1 and selection 2, the text of selected option should match expected text
public class DropdownTest extends DropdownMethod {

    @Test
    public void dropdownFirstTest() {
        startDropdownTest("1");
        assertEquals(selection,"Option 1");
    }

    @Test
    public void dropdownSecondTest() {
        startDropdownTest("2");
        assertEquals(selection,"Option 2");
    }
}
