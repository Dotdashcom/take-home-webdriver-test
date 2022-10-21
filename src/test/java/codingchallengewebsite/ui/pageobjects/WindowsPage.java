package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class WindowsPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Opening a new window']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Click Here']")
    private WebElement link;
    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='New Window']")
    private WebElement newTab;
    private final UITest caller;
    private final String pageUrl;

    public WindowsPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        this.caller.setDriver(driver);
        this.pageUrl = new StringBuilder().append(this.caller.getBaseUrl()).append("/windows").toString();
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() { // Check that the page loaded
        return caller.getDriver().getCurrentUrl().equals(this.pageUrl); }

    public void clickLink() {
        this.link.click(); }

    public boolean validateNewTab() {
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(30));
        String originalWindow = caller.getDriver().getWindowHandle();
        String expectedMessage ="New Window";
        String newTabHandle;

        this.clickLink();
        wait.until(numberOfWindowsToBe(2));

        //Loop through until we find a new window handle
        for (String windowHandle : caller.getDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                newTabHandle = windowHandle;
                caller.getDriver().switchTo().window(windowHandle);
                wait.until(titleIs("New Window"));
                return newTab.getText().equals(expectedMessage);
            }
        }
        return false;
    }
}