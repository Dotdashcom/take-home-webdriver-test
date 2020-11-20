package specs.CheckContextMenu;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageobjects.ContextMenu.ContextMenu;
import specs.AbstractSpec;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// #4 ContextMenu: http://localhost:7080/context_menu
// Right-click in the box to see one called 'the-internet'
// Test JavaScript alert text on Right-Click
public class CheckContextMenu extends AbstractSpec {
    private ContextMenu contextMenu;

    @BeforeTest
    public void setUp() {
        contextMenu = new ContextMenu(driver);
    }

    @BeforeMethod
    public void setUpTest() {
        // Open the targeted page
        driver.get("http://localhost:7080/context_menu");
    }

    @Test
    public void clkContextMenu() throws InterruptedException {
        SoftAssert softas = new SoftAssert();

        String expAlertMsg = "You selected a context menu";
        String actAlertMsg =  contextMenu.clkTheInternetSpot();

        // Validate Actual Alert menu text
        softas.assertTrue(actAlertMsg.equals(expAlertMsg),
                "Actual Alert menu text should be equal to expected: " + expAlertMsg);

        softas.assertAll();
    }

}
