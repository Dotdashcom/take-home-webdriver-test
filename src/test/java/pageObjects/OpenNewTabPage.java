package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class OpenNewTabPage extends Page {
    private static final By OPEN_NEW_TAB_LINK = By.linkText("Click Here");

    public OpenNewTabPage(ChromeDriver driver) {
        super(driver);
    }

    public NewWindowPage clickHere() {
        Set<String> windowHandles = driver.getWindowHandles();

        click(OPEN_NEW_TAB_LINK, BasePage.TIMEOUT);
        switchToWindow(windowHandles, 2);
        return new NewWindowPage(driver);
    }
}
