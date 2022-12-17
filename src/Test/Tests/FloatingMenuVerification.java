package Tests;

import Pages.BasePage;
import Pages.FloatingMenuPage;
import Utils.Driver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FloatingMenuVerification extends BasePage {
    FloatingMenuPage floatingMenuPage = new FloatingMenuPage();

    @BeforeClass
    public void SetUp() {
        Driver.GetDriver().get("http://localhost:7080/floating_menu");
    }

    @Test
    public void TC1VerificationOfFloatingMenu() {
        floatingMenuPage.FloatingMenu();
    }
}
