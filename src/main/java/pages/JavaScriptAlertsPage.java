package pages;

import core.AbstractWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JavaScriptAlertsPage extends AbstractWebPage {

    @FindBy(css ="#content > div > ul > li > button")
    protected List<WebElement> jsButtons;

    @FindBy(css ="div.example ul>li>:nth-child(1)")
    protected List<WebElement> alertElm;

    @FindBy(id = "result")
    protected WebElement resultMessage;

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnJSAlertButton() {
        jsButtons.get(0).click();
        sleepInSeconds(1);
    }

    public String getJSAlertText() {
        String textInAlert = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return textInAlert;
    }

    public void clickOnJSConfirmButton() {
        jsButtons.get(1).click();
        sleepInSeconds(1);
    }

    public void clickOnJSPromptButton() {
        jsButtons.get(2).click();
        sleepInSeconds(1);
    }

    public void setMessageOnJSPrompt(String text) {
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    public String getResultMessage() {
        return resultMessage.getText();
    }
}
