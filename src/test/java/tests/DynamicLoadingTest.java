package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoading;

public class DynamicLoadingTest extends TestBase {
    @Test
    public void test() {
        driver.get("http://localhost:7080/dynamic_loading/2 ");
        DynamicLoading loading = new DynamicLoading(driver);
        loading.pressStart(driver);
        Assert.assertEquals(loading.isTextDisplayed(), "Hello World!");
    }
}
