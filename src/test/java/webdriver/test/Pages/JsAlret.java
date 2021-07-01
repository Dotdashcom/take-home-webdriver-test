package webdriver.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.test.Util.PageLoader;


public class JsAlret {

    //local webdriver variable
    private WebDriver driver;

    @FindBy(css = "button[onclick='jsAlert()']")
    WebElement buttonJsAlert;

    @FindBy(css = "button[onclick='jsConfirm()']")
    WebElement buttonJsConfirm;

    @FindBy(css = "button[onclick='jsPrompt()']")
    WebElement buttonJsPrompt;

    @FindBy(id = "result")
    private WebElement resultText;

    //Page Class Constructor
    public JsAlret(WebDriver driver){

        this.driver = driver;

        this.loadPage();

        PageFactory.initElements(driver, this);

    }

    public void clickJsAlertButton() {
        buttonJsAlert.click();
    }

    public void acceptDialog() {
        driver.switchTo().alert().accept();
    }

    public void dismissDialog() {
        driver.switchTo().alert().dismiss();
    }

    public void clickJsConfirmButton() {
        buttonJsConfirm.click();
    }


    public void clickJSCancelDialog() {
        driver.switchTo().alert().dismiss();
    }

    public void clickJsPromptButton() {
        buttonJsPrompt.click();
    }

    public void AddTextToPromptDialog(String text) {
        driver.switchTo().alert().sendKeys(text);

    }

    public String getResultText() {
        return resultText.getText();
    }
    //page Load

    private void loadPage() {
        PageLoader.initializePage(driver, "/javascript_alerts");
    }
}
