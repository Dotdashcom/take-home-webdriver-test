package src.test;

import org.testng.annotations.Test;
import src.main.pages.CheckBoxesPage;
import src.main.pages.DynamicLoadingPage;
import src.main.utilities.Browser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class DynamicLoadingTest extends BaseTest {



    private DynamicLoadingPage dynamicLoadingPage;

    @Test
    public void dynamicLoadingTest() {
        dynamicLoadingPage = Browser.open(baseURL + "dynamic_loading/1", DynamicLoadingPage.class);

        dynamicLoadingPage.clickStartButtonAndWaitUntilLoadFinish();
        assertEquals(dynamicLoadingPage.getLoadedText(), "Hello World!");
    }

}
