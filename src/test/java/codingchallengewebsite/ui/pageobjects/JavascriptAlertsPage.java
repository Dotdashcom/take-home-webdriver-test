package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Alert;
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

public class JavascriptAlertsPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='JavaScript Alerts']")
    public WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//button")
    public List<WebElement> buttons;
    @FindBy(how = How.XPATH, using = "//p[@id='result']")
    public WebElement resultTextMessage;
    private final UITest caller;
    private final WebDriverWait genericWait;
    private final ArrayList<String> popupMessages = new ArrayList<>();
    private final String pageUrl;
    private final String mainWindow;

    public JavascriptAlertsPage(@NotNull UITest caller) {
        this.caller = caller;
        this.genericWait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(10));
        this.pageUrl = caller.getBaseUrl() + "/javascript_alerts";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(this.caller.getDriver(), this);
        this.caller.pageFactoryInitWait(pageTitle);
        this.mainWindow = this.caller.getDriver().getWindowHandle();
        popupMessages.add("I am a JS Alert"); popupMessages.add("I am a JS Confirm"); popupMessages.add("I am a JS prompt");
    }

    public Boolean isPageOpen() { return this.caller.isPageOpen(this.pageUrl, this.pageTitle); }

    public Boolean validatePopupsDisplay(Boolean skipMessages) {
        Actions builder = new Actions(caller.getDriver());
        Alert alertPopup;
        String popUpMessage;
        Boolean success = true;
        int i = 0;

        for (WebElement button : this.buttons) {
            genericWait.until(ExpectedConditions.visibilityOf(button));
            genericWait.until(ExpectedConditions.elementToBeClickable(button));
            builder.moveToElement(button).click(button).perform();
            genericWait.until(ExpectedConditions.alertIsPresent());

            try {
                alertPopup = caller.getDriver().switchTo().alert();
                popUpMessage = alertPopup.getText();
                if (!popUpMessage.equals(popupMessages.get(i))) {
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

    public Boolean validatePopupInputField() {
        Actions builder = new Actions(caller.getDriver());
        Alert alertPopup;
        String inputMessage = "This is a test message";
        WebElement buttonTobeTested = this.buttons.get(2);

        genericWait.until(ExpectedConditions.visibilityOf(buttonTobeTested));
        genericWait.until(ExpectedConditions.elementToBeClickable(buttonTobeTested));
        builder.moveToElement(buttonTobeTested).click(buttonTobeTested).perform();

        try {
            alertPopup = caller.getDriver().switchTo().alert();
            alertPopup.sendKeys(inputMessage);
            alertPopup.accept();
            caller.getDriver().switchTo().window(this.mainWindow);
            return resultTextMessage.getText().equals("You entered: "+inputMessage);
        }
        catch (Exception e) {
            return false;
        }
    }
}