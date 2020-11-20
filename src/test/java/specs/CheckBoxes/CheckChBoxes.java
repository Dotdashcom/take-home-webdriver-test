package specs.CheckBoxes;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageobjects.CheckBoxes.CheckBoxes;
import specs.AbstractSpec;

import java.util.HashMap;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// #3 CheckBoxes: http://localhost:7080/checkboxes Check and uncheck boxes
public class CheckChBoxes extends AbstractSpec {
    private CheckBoxes checkBoxes;

    @BeforeTest
    public void setUp() {
        checkBoxes = new CheckBoxes(driver);
    }

    @Test(priority = 1, enabled = true)
    public void checkIn() throws InterruptedException {
        // Open the targeted page
        driver.get("http://localhost:7080/checkboxes");

        SoftAssert softas = new SoftAssert();

        // Get Expected values
        HashMap<Integer, Boolean> originalStates = checkBoxes.orgChecked();

        // Get Actual values after the option selection
        HashMap<Integer, Boolean> actualStates = checkBoxes.clkChecked();

        // Validate heckBox values being opposite to the original states
        for (Integer i : originalStates.keySet()) {
            softas.assertFalse(originalStates.get(i) == actualStates.get(i),
                    "#"+Integer.toString(i+1)+" CheckBox value must be opposite to the original state");
        }

        softas.assertAll();
    }

    @Test(priority = 2, enabled = true)
    public void checkOut() throws InterruptedException {
        SoftAssert softas = new SoftAssert();

        HashMap<Integer, Boolean> originalStates = checkBoxes.orgChecked();
        HashMap<Integer, Boolean> actualStates = checkBoxes.clkChecked();

        // Validate heckBox values being opposite to the original states
        for (Integer i : originalStates.keySet()) {
            softas.assertFalse(originalStates.get(i) == actualStates.get(i),
                    "#"+Integer.toString(i+1)+" CheckBox value must be opposite to the original state");
        }

        softas.assertAll();
    }

}
