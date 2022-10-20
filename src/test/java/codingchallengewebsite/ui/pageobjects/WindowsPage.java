package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static codingchallengewebsite.ui.UITests.DEFAULT_BASE_URL;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class WindowsPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Opening a new window']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Click Here']")
    private WebElement link;
    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='New Window']")
    private WebElement newTab;
    private UITests caller;
    private final String pageUrl;
    public WebDriver driver;


    public WindowsPage(WebDriver driver, UITests caller) {
        this.caller = caller;
        this.driver = driver;
        this.pageUrl = new StringBuilder().append(DEFAULT_BASE_URL).append("/windows").toString();
        this.driver.get(this.pageUrl);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() { // Check that the page loaded
        return this.driver.getCurrentUrl().equals(this.pageUrl); }

    public void clickLink() {
        this.link.click();
    }

    public boolean validateNewTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String originalWindow = driver.getWindowHandle();
        String expectedMessage ="New Window";
        String newTabHandle;

        this.clickLink();
        wait.until(numberOfWindowsToBe(2));

        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                newTabHandle = windowHandle;
                driver.switchTo().window(windowHandle);
                wait.until(titleIs("New Window"));
                newTab.getText().equals(expectedMessage);
                return true;
            }
        }
        return false;
    }



}
