package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicLoadingPage extends Page {
    private static final By START_BUTTON = By.xpath("//div[@id='start']/button");
    private static final By HEADER_TEXT = By.xpath("//div[@id='finish']/h4");

    public DynamicLoadingPage(ChromeDriver driver) {
        super(driver);
    }

    public DynamicLoadingPage clickStartButton() {
        click(START_BUTTON, BasePage.TIMEOUT);
        return this;
    }

    public String getHeaderText() {
        return visibilityOfElementLocated(HEADER_TEXT, BasePage.TIMEOUT).getText();
    }
}
