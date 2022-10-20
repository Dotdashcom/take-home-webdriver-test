package src.main.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class JavaScriptAlertsPage extends BasePage {
    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#content > div.example > ul > li:first-child > button")
    private WebElement alertButton;

    @FindBy(css = "#content > div.example > ul > li:nth-child(2) > button")
    private WebElement confirmButton;

    @FindBy(css = "#content > div.example > ul > li:last-child > button")
    private WebElement promptButton;

    @FindBy(id = "result")
    private WebElement alertResult;


    public void triggerAlert(){
        alertButton.click();
    }
    public void triggerConfirm(){
        confirmButton.click();
    }
    public void triggerPrompt(){
        promptButton.click();
    }
    public void acceptAlert(){
        getDriver().switchTo().alert().accept();
    }

    public void dismissAlert(){
        getDriver().switchTo().alert().dismiss();
    }

    public String geAlertText(){
        return getDriver().switchTo().alert().getText();
    }

    public void setInput(String text){
        getDriver().switchTo().alert().sendKeys(text);
    }

    public String getResult(){
        return alertResult.getText();
    }
}

