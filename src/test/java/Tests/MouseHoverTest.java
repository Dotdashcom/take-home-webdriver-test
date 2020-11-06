package Tests;

import PageRepositories.MouseHovers;
import Utils.UITestListeners;
import io.qameta.allure.*;
import org.testng.annotations.*;

@Listeners({ UITestListeners.class })
public class MouseHoverTest extends BaseTest {
    @Test(priority=1)
    @Description("Test Mouse Hover Functionality")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Mouse Hover")
    public void mouse_hover_test() {
        MouseHovers mouseHovers = new MouseHovers(driver);

        mouseHovers.navigate_to_mouse_hovers_page(base_url);
        mouseHovers.validate_mouse_hovers_page_header();

        mouseHovers.mouse_hover_to_image("1");
        mouseHovers.validate_information_is_displayed("1");
        mouseHovers.validate_information_is_not_displayed("2");
        mouseHovers.validate_information_is_not_displayed("3");

        mouseHovers.mouse_hover_to_image("2");
        mouseHovers.validate_information_is_displayed("2");
        mouseHovers.validate_information_is_not_displayed("1");
        mouseHovers.validate_information_is_not_displayed("3");

        mouseHovers.mouse_hover_to_image("3");
        mouseHovers.validate_information_is_displayed("3");
        mouseHovers.validate_information_is_not_displayed("1");
        mouseHovers.validate_information_is_not_displayed("2");
    }
}
