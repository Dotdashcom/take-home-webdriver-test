package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class JavaScriptAlertPage extends PageObject {
    public JavaScriptAlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//button[.='Click for JS Alert']")
    private WebElement btnJsAlert;

    @FindBy(how = How.XPATH, using = "//button[.='Click for JS Confirm']")
    private WebElement btnJsConfirm;

    @FindBy(how = How.XPATH, using = "//button[.='Click for JS Prompt']")
    private WebElement btnJsPrompt;

    @FindBy(how = How.ID, using = "result")
    private WebElement output;

    public void clickAlertButton() {
        btnJsAlert.click();
    }

    public void clickOkAlert() {
        driver.switchTo().alert().accept();
    }

    public void clickConfirmButton() {
        btnJsConfirm.click();
    }

    public void clickOkConfirm() {
        driver.switchTo().alert().accept();
    }

    public void clickCancelConfirm() {
        driver.switchTo().alert().dismiss();
    }

    public void clickPromptButton() {
        btnJsPrompt.click();
    }

    public void clickOkPrompt(String text) {
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    public void clickCancelPrompt() {
        driver.switchTo().alert().dismiss();
    }

    public String getOutputText() {
        return output.getText();
    }
}
