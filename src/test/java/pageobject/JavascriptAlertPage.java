package pageobject;

import base.EndPointPath;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavascriptAlertPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(), 'Click for JS Alert')]")
    private WebElement JSAlert;

    @FindBy(xpath = "//button[contains(text(), 'Click for JS Confirm')]")
    private WebElement JSConfirm;

    @FindBy(xpath = "//button[contains(text(), 'Click for JS Prompt')]")
    private WebElement JSPrompt;

    @FindBy(id = "result")
    private WebElement result;

    private final static String prefixResult = "You entered: ";


    public JavascriptAlertPage(WebDriver driver) {
        super(driver, EndPointPath.JAVASCRIPT_ALERT);

    }


    public String verifyJSAlert() {
        JSAlert.click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        alert.accept();
        return message;
    }

    public String verifyJSConfirm() {
        JSConfirm.click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        alert.accept();
        return message;
    }

    public String verifyJSPrompt(String text) {
        JSPrompt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
        return result.getText().replace(prefixResult, "");
    }


}
