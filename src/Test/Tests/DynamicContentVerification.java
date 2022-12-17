package Tests;

import Pages.BasePage;
import Pages.DynamicContentPage;
import Utils.Driver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicContentVerification extends BasePage {
    DynamicContentPage dynamicContentPage = new DynamicContentPage();

    @BeforeClass
    public void SetUp() {
        Driver.GetDriver().get("http://localhost:7080/dynamic_content");
    }

    @Test
    public void TC1DynamicContentVerification() {
        dynamicContentPage.DynamicContent();
    }
}
