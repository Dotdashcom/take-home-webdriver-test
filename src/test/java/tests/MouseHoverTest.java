package tests;

import enums.Pages;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.MouseHoverPage;
import utilities.BrowserUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class MouseHoverTest extends TestBase {

    @Test(description = "Mouse Hover Test")
    public void mouseHoverTest() {
        MouseHoverPage mouseHoverPage = new MouseHoverPage();
        BrowserUtils.openPage(driver, Pages.MOUSE_HOVER_PAGE);
        Actions actions = new Actions(driver);
        for (int i = 0; i < mouseHoverPage.allimages.size(); i++) {
            actions.moveToElement(mouseHoverPage.allimages.get(i)).perform();
            assertThat(mouseHoverPage.usersText.get(i).isDisplayed()).isTrue();
            assertThat(mouseHoverPage.usersText.get(i).getText()).isEqualTo("name: user" + (i + 1));
        }
    }
}
