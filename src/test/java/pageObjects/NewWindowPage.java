package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowPage extends Page {
    private static final By HEADER = By.tagName("h3");

    public NewWindowPage(ChromeDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return getText(HEADER, BasePage.TIMEOUT);
    }
}
