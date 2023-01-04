package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicContentPage extends Page {
    private static final By CONTENT = By.id("content");

    public DynamicContentPage(ChromeDriver driver) {
        super(driver);
    }

    public String getContentText() {
        return getText(CONTENT, BasePage.TIMEOUT);
    }
}
