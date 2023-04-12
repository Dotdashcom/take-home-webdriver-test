package page_object_model.javascript_alerts_page;

import base.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertsPage extends Base {

    public JavaScriptAlertsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    private WebElement jsAlertButton;
    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    private WebElement jsConfirmButton;
    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    private WebElement jsPromptButton;

//    @FindBy(xpath = "//p[text()='You successfuly clicked an alert']")
//    public static WebElement successfullyClickedAlert;
//
//    @FindBy(xpath = "//p[text()='//p[text()='You clicked: Ok']']")
//    public static WebElement ClickedOkAlertMessage;

    @FindBy(id = "result")
    public static WebElement alertMessage;

    public void clickAlertButton() {
        jsClickOnElement(jsAlertButton);
        driver.switchTo().alert().accept();
    }

    public void clickForJsConfirmButton() {
        jsClickOnElement(jsConfirmButton);
        driver.switchTo().alert().accept();
    }

    public void clickForJsPromptButton(String word) {
        jsClickOnElement(jsPromptButton);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(word);
        alert.accept();
    }
}
