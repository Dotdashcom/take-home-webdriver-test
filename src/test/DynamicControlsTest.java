package src.test;

import org.testng.annotations.Test;
import src.main.pages.*;
import src.main.pages.DynamicControlsPage;
import src.main.utilities.Browser;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class DynamicControlsTest extends BaseTest {



    private DynamicControlsPage dynamicControlsPage;

    @Test
    public void dynamicControlsTest() {
        dynamicControlsPage = Browser.open(baseURL + "dynamic_controls", DynamicControlsPage.class);

        dynamicControlsPage.clickAddRemoveButtonAndWaitUntilFinish();
        assertFalse(dynamicControlsPage.isCheckBoxPresent());

        dynamicControlsPage.clickAddRemoveButtonAndWaitUntilFinish();
        assertTrue(dynamicControlsPage.isCheckBoxPresent());
        Browser.refresh();

        dynamicControlsPage.clickEnableDisableButtonAndWaitUntilFinish();
        assertTrue(dynamicControlsPage.isFieldEnabled());
        dynamicControlsPage.clickEnableDisableButtonAndWaitUntilFinish();
        assertFalse(dynamicControlsPage.isFieldEnabled());
    }

}
