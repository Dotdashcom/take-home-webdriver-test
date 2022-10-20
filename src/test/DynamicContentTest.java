package src.test;

import org.testng.annotations.Test;
import src.main.pages.DynamicContentPage;
import src.main.utilities.Browser;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertTrue;

public class DynamicContentTest extends BaseTest {



    private DynamicContentPage dynamicContentPage;

    @Test
     public void dynamicContentTest() {
        dynamicContentPage = Browser.open(baseURL + "dynamic_content", DynamicContentPage.class);

        String beforeText = dynamicContentPage.get(0);
        Browser.refresh();
        String afterText = dynamicContentPage.get(0);
        assertNotEquals(beforeText, afterText);
    }

}
