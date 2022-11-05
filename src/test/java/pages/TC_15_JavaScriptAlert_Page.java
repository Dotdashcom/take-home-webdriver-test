package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC_15_JavaScriptAlert_Page {
    public TC_15_JavaScriptAlert_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText =  "JavaScript Alerts")
    public WebElement JavaScriptLink;

    @FindBy(xpath = "(//button[1])[1]")
    public WebElement JavaScriptAlert;

    @FindBy(xpath = "(//button[1])[2]")
    public WebElement JsConfirm;

    @FindBy(xpath = "(//button[1])[3]")
    public WebElement JsPrompt;

    @FindBy(xpath = "//p[@id='result']")
    public WebElement ResultTextJs;

}
