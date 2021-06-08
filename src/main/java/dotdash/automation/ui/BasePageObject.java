package dotdash.automation.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is the base page object which are extended by other PO. It makes sure that driver is passed to the PO
 * It can be used to declare common page objects methods like waits, getTitle
 */
public class BasePageObject {

    protected WebDriverWait wait;

    protected WebDriver driver;

    protected BasePageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
