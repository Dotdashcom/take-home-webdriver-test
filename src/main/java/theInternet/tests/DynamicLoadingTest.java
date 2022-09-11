package theInternet.tests;

import org.testng.annotations.Test;
import theInternet.pages.DynamicLoading;

public class DynamicLoadingTest extends TestBase {

    @Test
    public void dynamicLoadingTest() throws InterruptedException {
        DynamicLoading dynamicLoading = new DynamicLoading(driver);
        dynamicLoading.getHidden(driver);
        dynamicLoading.getRendered(driver);

    }
}
