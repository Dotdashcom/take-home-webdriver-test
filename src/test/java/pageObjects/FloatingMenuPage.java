package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FloatingMenuPage extends Page {
    private static final By FLOATING_MENU = By.id("menu");

    public FloatingMenuPage(ChromeDriver driver) {
        super(driver);
    }

    public boolean isFloatingMenuPresent() {
        return isElementLocatedVisible(FLOATING_MENU, BasePage.TIMEOUT);
    }
}
