package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicContent;

public class DynamicContentTest extends TestBase {
    @Test
    public void test() {
        driver.get("http://localhost:7080/dynamic_content");
        DynamicContent content = new DynamicContent(driver);
        Assert.assertTrue(content.reload(driver));

    }
}
