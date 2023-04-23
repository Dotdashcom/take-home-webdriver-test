import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IframePage extends BasePage {
    private String path = "/iframe";

    private By iframeBy = By.xpath("//iframe[@id=\"mce_0_ifr\"]");
    private By iframeBodyBy = By.xpath("//body[@id=\"tinymce\"]");

    IframePage(WebDriver webdriver) {
        driver = webdriver;
    }

    public String getUrl() {
        String url = getBaseUrl() + path;
        return url;
    }

    public void waitForIframeLoad(int timeoutSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSec);

        // Wait for iframe to load and switch to it
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeBy));

        // Wait for the text box inside iframe to be ready to recieve text
        wait.until(ExpectedConditions.elementToBeClickable(iframeBodyBy));

        // Leave iframe
        leaveIframe();
    }

    public void switchToIframe() {
        WebElement iframe = driver.findElement(iframeBy);

        // switch to iframe
        driver.switchTo().frame(iframe);
    }

    public void leaveIframe() {
        driver.switchTo().defaultContent();
    }

    public void clearIframeText() {
        switchToIframe();

        driver.findElement(iframeBodyBy).clear();

        leaveIframe();
    }

    public void enterTextToIframe(String text) {
        switchToIframe();

        driver.findElement(iframeBodyBy).sendKeys(text);

        leaveIframe();
    }

    public String getIframeText() {
        switchToIframe();

        String text = driver.findElement(iframeBodyBy).getText();

        leaveIframe();

        return text;
    }

}
