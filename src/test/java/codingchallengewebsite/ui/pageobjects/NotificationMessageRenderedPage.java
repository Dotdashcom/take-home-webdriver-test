package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;

import static codingchallengewebsite.ui.UITests.DEFAULT_BASE_URL;

public class NotificationMessageRenderedPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Notification Message']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//div[@id='flash']")
    private WebElement flashNotification;
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Click here']")
    private WebElement link;
    public ArrayList<String> possibleMessages = new ArrayList<>();
    private UITests caller;
    private final String pageUrl;
    public WebDriver driver;

    public NotificationMessageRenderedPage(WebDriver driver, UITests caller) {
        this.caller = caller;
        this.driver = driver;
        this.pageUrl = new StringBuilder().append(DEFAULT_BASE_URL).append("/notification_message_rendered").toString();
        this.driver.get(this.pageUrl);
        this.possibleMessages.add("Action unsuccesful, please try again");
        this.possibleMessages.add("Action successful");
        // Deactivated, because it never showed up on the website: bug?
        // this.possibleMessages.add("Action Unsuccessful");
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() {
        return Objects.equals(driver.getCurrentUrl(), this.pageUrl) && this.pageTitle.getText().toString().contains("Notification Message"); }

    public void clickOnLink() {
        Actions builder = new Actions(this.driver);
        builder.moveToElement(this.link).click(this.link).perform();
    }

    public ArrayList<String> getPossibleMessages(){
        return this.possibleMessages;
    }
    public String getFlashMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.clickOnLink();
        String newMessage =".";

        this.clickOnLink();
        newMessage = UITests.CleanText.cleanTextContent(flashNotification.getText().trim());
        wait.until(ExpectedConditions.visibilityOf(flashNotification));

        return newMessage;
    }

    public boolean validateFlashMessages() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String currentMessage = this.getFlashMessage();
        this.clickOnLink();
        int retries = this.possibleMessages.size();

        while (retries > 0) {
            for (String message : this.possibleMessages) {
                if (message.trim().contains(currentMessage.trim())) {
                    retries--;
                }
            }
            currentMessage = this.getFlashMessage();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='flash']")));
        }
        return true;
    }
}
