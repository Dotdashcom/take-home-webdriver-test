package pages;

import org.company.configReader.ConfigReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JavaScriptAlertPage {
    private WebDriver driver;
    private SoftAssert softAssert;

    public JavaScriptAlertPage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    private WebElement alertBtn;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    private WebElement confirmBtn;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    private WebElement clickBtn;

    @FindBy(id="result")
    private WebElement textResult;

    public void checkJSAlerts() {
        navigateToJSAlertPage();
        clickAndVerifyJSAlertBtn();
        clickAndVerifyClickBtn();
        clickOnClickBtnAndTypeText();
    }
    private void clickAndVerifyJSAlertBtn(){
        alertBtn.click();
        Alert alert=driver.switchTo().alert();
        softAssert.assertEquals(alert.getText().trim(),"I am a JS Alert","Alert msg is not correct");
        alert.accept();
    }
    private void clickAndVerifyClickBtn() {
        confirmBtn.click();
        Alert alert=driver.switchTo().alert();
        softAssert.assertEquals(alert.getText().trim(),"I am a JS Confirm","Alert msg is not correct");
        alert.accept();
    }
    private void clickOnClickBtnAndTypeText(){
        clickBtn.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys(ConfigReader.getProperty("inputText"));
        alert.accept();
        softAssert.assertEquals(textResult.getText(),"You entered: "+ConfigReader.getProperty("inputText"),"Alert msg does not match");

    }

    private void navigateToJSAlertPage(){
        driver.get(ConfigReader.getProperty("url")+"/javascript_alerts ");
    }
}
