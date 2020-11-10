package Tests;

import PageRepositories.Iframe;
import Utils.UITestListeners;
import io.qameta.allure.*;
import org.testng.annotations.*;

@Listeners({ UITestListeners.class })
public class IframeTest extends BaseTest {
    @Test(priority=1)
    @Description("Switch to Iframe and Type in Text Area")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Iframe")
    public void switch_to_iframe_and_type_text() {
        Iframe iframe = new Iframe(driver);

        iframe.navigate_to_iframe_page(base_url);
        iframe.validate_iframe_page_header();
        iframe.switch_to_iframe();
        iframe.type_in_iframe_text_area();
        iframe.verify_iframe_text();
    }
}
