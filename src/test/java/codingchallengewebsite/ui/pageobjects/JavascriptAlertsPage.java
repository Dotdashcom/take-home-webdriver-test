package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITests;
import org.openqa.selenium.Alert;
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
import java.util.List;

import static codingchallengewebsite.ui.UITests.DEFAULT_BASE_URL;

public class JavascriptAlertsPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='JavaScript Alerts']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//button")
    private List<WebElement> buttons;
    @FindBy(how = How.XPATH, using = "//p[@id='result']")
    private WebElement resultTextMessage;
    private final UITests caller;
    public WebDriver driver;
    private ArrayList<String> popupMessages = new ArrayList<>();
    private final String pageUrl;
    private final String mainWindow;

    public JavascriptAlertsPage(WebDriver driver, UITests caller) {
        this.caller = caller;
        this.driver = driver;
        this.pageUrl = new StringBuilder().append(DEFAULT_BASE_URL).append("/javascript_alerts").toString();
        driver.get(this.pageUrl);
        PageFactory.initElements(driver, this);
        this.mainWindow = this.driver.getWindowHandle();
        popupMessages.add("I am a JS Alert"); popupMessages.add("I am a JS Confirm"); popupMessages.add("I am a JS prompt");
    }

    public boolean isPageOpen() { return this.driver.getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().contains("JavaScript Alerts"); }

    public boolean validatePopupsDisplay(boolean skipMessages) {
        Actions builder = new Actions(this.driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Alert alertPopup;
        String popUpMessage;
        boolean success = true;
        int i = 0;

        for (WebElement button : this.buttons) {
            wait.until(ExpectedConditions.elementToBeClickable(button));
            builder.moveToElement(button).click(button).perform();

            wait.until( d -> {
                ExpectedConditions.alertIsPresent();
                return true;
            });

            try {
                alertPopup = this.driver.switchTo().alert();
                popUpMessage = alertPopup.getText().toString();
                if (!popUpMessage.equals(popupMessages.get(i).toString())) {
                    alertPopup.dismiss();
                    return false;
                }
                alertPopup.dismiss();
                this.driver.switchTo().window(this.mainWindow);
            }
            catch (Exception e) {
                return false;
            }

            i++;
        }
        return success;
    }

    public boolean validatePopupInputField() {
        Actions builder = new Actions(this.driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Alert alertPopup;
        String inputMessage = "This is a test message";
        WebElement buttonTobeTested = this.buttons.get(2);

        wait.until(ExpectedConditions.elementToBeClickable(buttonTobeTested));
        builder.moveToElement(buttonTobeTested).click(buttonTobeTested).perform();

        try {
            alertPopup = this.driver.switchTo().alert();
            alertPopup.sendKeys(inputMessage);
            alertPopup.accept();
            this.driver.switchTo().window(this.mainWindow);
            return resultTextMessage.getText().toString().equals("You entered: "+inputMessage);
        }
        catch (Exception e) {
            return false;
        }
    }
}
