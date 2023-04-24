package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSAlertsPage extends BasePage {
    private String path = "/javascript_alerts";

    private By jsAlertButtonBy = By.xpath("//button[contains(text(), \"JS Alert\")]");
    private By jsConfirmButtonBy = By.xpath("//button[contains(text(), \"JS Confirm\")]");
    private By jsPromptButtonBy = By.xpath("//button[contains(text(), \"JS Prompt\")]");
    private By resultBy = By.xpath("//p[@id=\"result\"]");

    private String jsAlertSuccess = "You successfuly clicked an alert";
    private String jsConfirmOK = "You clicked: Ok";
    private String jsConfirmCancel = "You clicked: Cancel";
    private String jsPromptSuccess = "You entered:";
    private String promptValue = "this is a test input";

    private Alert alert;

    public JSAlertsPage(WebDriver webdriver) {
        driver = webdriver;
    }

    public String getUrl() {
        String url = getBaseUrl() + path;
        return url;
    }

    public void waitForJSAlert(int timeoutSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSec);

        wait.until(ExpectedConditions.alertIsPresent());
    }

    // Returns null if no alert was found
    public Alert accessAlert() throws NoAlertPresentException {
        try {
            alert = driver.switchTo().alert();
            return alert;
        } catch (NoAlertPresentException e) {
            return null;
        }
    }

    public void clickJSAlertButton() {
        driver.findElement(jsAlertButtonBy).click();
    }

    public void clickJSConfirmButton() {
        driver.findElement(jsConfirmButtonBy).click();
    }

    public void clickJSPromptButton() {
        driver.findElement(jsPromptButtonBy).click();
    }

    public void enterPromptText(String text) {
        accessAlert();
        alert.sendKeys(text);
    }

    public void acceptJSAlert() {
        accessAlert();
        alert.accept();
    }

    public void dismissJSAlert() {
        accessAlert();
        alert.dismiss();
    }

    public boolean jsAlertSuccessResult() {
        return driver.findElement(resultBy).getText().equals(jsAlertSuccess);
    }

    public boolean jsConfirmOKResult() {
        return driver.findElement(resultBy).getText().equals(jsConfirmOK);
    }

    public boolean jsConfirmCancelResult() {
        return driver.findElement(resultBy).getText().equals(jsConfirmCancel);
    }

    public boolean jsPromptSuccessResult(String promptText) {
        if (promptText.equals(""))
            return driver.findElement(resultBy).getText().equals(jsPromptSuccess);
        else
            return driver.findElement(resultBy).getText().equals(jsPromptSuccess + " " + promptText);
    }
}
