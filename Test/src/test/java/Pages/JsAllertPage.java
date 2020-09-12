package Pages;

import Utils.BrowserUtils;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class JsAllertPage extends PageBase {

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    WebElement clickForJsAllert1;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    WebElement clickForJsAllert2;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    WebElement clickForJsAllert3;

    @FindBy(xpath = "//p[@id='result']")
    WebElement verifyResult;



    public void clickinOnAlerts(){
        BrowserUtils.click(clickForJsAllert1);
        BrowserUtils.jSAlertTap();
        BrowserUtils.click(clickForJsAllert2);
        BrowserUtils.jSAlertTap();
        BrowserUtils.click(clickForJsAllert3);
        BrowserUtils.jSAlertSenKeys("TEXT");
        BrowserUtils.jSAlertTap();

        Assert.assertEquals("You entered: TEXT",verifyResult.getText());

    }
}
