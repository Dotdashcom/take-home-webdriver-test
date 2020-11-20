package specs.DragAndDrop;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageobjects.DragAndDrop.DragAndDrop;
import specs.AbstractSpec;

import java.util.HashMap;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// #5 Drag and Drop: http://localhost:7080/drag_and_drop Perform Drag And Drop in a WebDriver test.
public class CheckDragAndDrop extends AbstractSpec {
    private DragAndDrop dragAndDrop;

    @BeforeTest
    public void setUp() {
        dragAndDrop = new DragAndDrop(driver);
    }

    @BeforeMethod
    public void setUpTest() {
        // Open the targeted page
        driver.get("http://localhost:7080/drag_and_drop");
    }

    @Test
    public void checkDragAndDrop() throws InterruptedException {
        SoftAssert softas = new SoftAssert();

        // Get Expected values
        HashMap<String, String> expHeaders  = dragAndDrop.expDrapAndDrop();

        // Get Actual values
        HashMap<String, String> actHeaders  = dragAndDrop.actDrapAndDrop();

        // Validate Column header text
        for (String i : expHeaders.keySet()) {
            softas.assertFalse(expHeaders.get(i).equals(actHeaders.get(i)),
                    i+": The text on element A and B are switched!");
        }

        softas.assertAll();
    }

}
