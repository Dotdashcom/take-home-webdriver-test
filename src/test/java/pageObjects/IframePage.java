package pageObjects;

import base.BasePage;
import base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframePage extends Page {
    private static final By CLOSE_BUTTON = By.xpath("//div[@aria-label='Close']");
    private static final String IFRAME_ID = "mce_0_ifr";
    private static final By CONTENT = By.xpath("//body[@id='tinymce']/p");

    private WebElement contentElement;

    public IframePage(ChromeDriver driver) {
        super(driver);
    }

    public IframePage clickCloseButton() {
        click(CLOSE_BUTTON, BasePage.TIMEOUT);
        return this;
    }

    public IframePage switchToFrame() {
        visibilityOfElementLocated(By.id(IFRAME_ID), BasePage.TIMEOUT);
        switchToFrame(IFRAME_ID);
        return this;
    }

    public IframePage enterContent(String text) {
        contentElement = visibilityOfElementLocated(CONTENT, BasePage.TIMEOUT);
        contentElement.sendKeys(text);
        return this;
    }

    public String getContentText() {
        return contentElement.getText();
    }
}
