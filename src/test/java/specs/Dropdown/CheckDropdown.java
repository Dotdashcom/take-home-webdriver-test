package specs.Dropdown;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageobjects.Dropdown.Dropdown;
import specs.AbstractSpec;

import java.util.HashMap;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// #6 Dropdown: http://localhost:7080/dropdown Test dropdown using Webdriver
public class CheckDropdown extends AbstractSpec {
    private Dropdown dropdown;

    @BeforeTest
    public void setUp() {
        dropdown = new Dropdown(driver);
    }

    @BeforeMethod
    public void setUpTest() {
        // Open the targeted page
        driver.get("http://localhost:7080/dropdown");
    }

    @Test
    public void checkDropdown() throws InterruptedException {
        SoftAssert softas = new SoftAssert();

        HashMap<Integer, String> expOptions  = dropdown.expOptions();
        HashMap<Integer, String> actOptions  = dropdown.actOptions();

        // Validate Dropdown selected options
        for (Integer i : expOptions.keySet()) {
            softas.assertTrue(expOptions.get(i).equals(actOptions.get(i)),
                    i + " Dropdown selection contains the incorrect value or doesn't work");
        }

        softas.assertAll();
    }


}
