package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;

public class NotificationMessageRenderedPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Notification Message']")
    public WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Click here']")
    public WebElement link;
    @FindBy(how = How.XPATH, using = "//div[@id='flash']")
    public WebElement flashNotification;
    public ArrayList<String> possibleMessages = new ArrayList<>();
    private final UITest caller;
    private final String pageUrl;

    public NotificationMessageRenderedPage(UITest caller) {
        this.caller = caller;
        this.pageUrl = this.caller.getBaseUrl() + "/notification_message_rendered";
        this.caller.getDriver().get(this.pageUrl);
        this.possibleMessages.add("Action unsuccesful, please try again");
        this.possibleMessages.add("Action successful");
        // Deactivated, because it never showed up on the website: bug?
        //---> this.possibleMessages.add("Action Unsuccessful");
        PageFactory.initElements(this.caller.getDriver(), this);
        this.caller.pageFactoryInitWait(pageTitle);
    }

    public Boolean isPageOpen() { return this.caller.isPageOpen(this.pageUrl, this.pageTitle); }

    public void clickOnLink() {
        Actions builder = new Actions(caller.getDriver());
        builder.moveToElement(this.link).click(this.link).perform();
    }

    public ArrayList<String> getPossibleMessages(){
        return this.possibleMessages; }

    public String getFlashMessage() {
        String newMessage;
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(30));
        this.clickOnLink();
        newMessage = UITest.cleanTextContent(flashNotification.getText().trim());
        wait.until(ExpectedConditions.visibilityOf(flashNotification));
        return newMessage;
    }

    public Boolean validateFlashMessages() {
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(30));
        String currentMessage = this.getFlashMessage();
        this.clickOnLink();
        int retries = this.getPossibleMessages().size();

        while (retries > 0) {
            for (String message : this.getPossibleMessages()) {
                if (message.trim().contains(currentMessage.trim())) {
                    retries--; }
            }
            currentMessage = this.getFlashMessage();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='flash']")));
        }
        return true;
    }
}