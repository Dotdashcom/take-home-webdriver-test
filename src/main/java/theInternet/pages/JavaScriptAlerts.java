package theInternet.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JavaScriptAlerts {

    public JavaScriptAlerts(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "JavaScript Alerts")
    WebElement JSAlerts;

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    WebElement alertButton;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    WebElement confirmButton;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    WebElement promptButton;

    @FindBy(id = "result")
    WebElement resultMsg;

    public void jsAlert(WebDriver driver){

        JSAlerts.click();
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        String expectedMsg ="I am a JS Alert";
        Assert.assertTrue(alert.getText().equals(expectedMsg));
        alert.dismiss();
    }

    public void jsConfirm(WebDriver driver){

        confirmButton.click();
        Alert alert = driver.switchTo().alert();
        String expectedMsg ="I am a JS Confirm";
        Assert.assertTrue(alert.getText().equals(expectedMsg));
        alert.dismiss();
    }
    public void jsPrompt(WebDriver driver){

        promptButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("I am an Alien");
        alert.accept();
        String expectedResult= "You entered: I am an Alien";
        Assert.assertTrue(resultMsg.getText().equals(expectedResult));
    }



}
