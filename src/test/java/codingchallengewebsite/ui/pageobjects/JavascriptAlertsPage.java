package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class JavascriptAlertsPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='JavaScript Alerts']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//button")
    private List<WebElement> buttons;
    @FindBy(how = How.XPATH, using = "//p[@id='result']")
    private WebElement resultTextMessage;
    private final UITest caller;
    private ArrayList<String> popupMessages = new ArrayList<>();
    private final String pageUrl;
    private final String mainWindow;

    public JavascriptAlertsPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        this.caller.setDriver(driver);
        this.pageUrl = new StringBuilder(caller.getBaseUrl()).append("/javascript_alerts").toString();
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
        this.mainWindow = this.caller.getDriver().getWindowHandle();
        popupMessages.add("I am a JS Alert"); popupMessages.add("I am a JS Confirm"); popupMessages.add("I am a JS prompt");
    }

    public boolean isPageOpen() {
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return caller.getDriver().getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().contains("JavaScript Alerts");
    }

    public boolean validatePopupsDisplay(boolean skipMessages) {
        Actions builder = new Actions(caller.getDriver());
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(10));
        Alert alertPopup;
        String popUpMessage;
        boolean success = true;
        int i = 0;

        for (WebElement button : this.buttons) {
            wait.until(ExpectedConditions.visibilityOf(button));
            wait.until(ExpectedConditions.elementToBeClickable(button));
            builder.moveToElement(button).click(button).perform();

            wait.until( d -> {
                ExpectedConditions.alertIsPresent();
                return true;
            });

            try {
                alertPopup = caller.getDriver().switchTo().alert();
                popUpMessage = alertPopup.getText().toString();
                if (!popUpMessage.equals(popupMessages.get(i).toString())) {
                    alertPopup.dismiss();
                    return false;
                }
                alertPopup.dismiss();
                caller.getDriver().switchTo().window(this.mainWindow);
            }
            catch (Exception e) {
                return false;
            }

            i++;
        }
        return success;
    }

    public boolean validatePopupInputField() {
        Actions builder = new Actions(caller.getDriver());
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(10));
        Alert alertPopup;
        String inputMessage = "This is a test message";
        WebElement buttonTobeTested = this.buttons.get(2);

        wait.until(ExpectedConditions.visibilityOf(buttonTobeTested));
        wait.until(ExpectedConditions.elementToBeClickable(buttonTobeTested));
        builder.moveToElement(buttonTobeTested).click(buttonTobeTested).perform();

        try {
            alertPopup = caller.getDriver().switchTo().alert();
            alertPopup.sendKeys(inputMessage);
            alertPopup.accept();
            caller.getDriver().switchTo().window(this.mainWindow);
            return resultTextMessage.getText().toString().equals("You entered: "+inputMessage);
        }
        catch (Exception e) {
            return false;
        }
    }
}