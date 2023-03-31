package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptAlert {
    public JavaScriptAlert(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[.='Click for JS Alert']")
    WebElement alertJSButton;
    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    WebElement jsConfirm;
    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    WebElement jsPromt;

    public String clickJSButton(WebDriver driver) {
        alertJSButton.click();
        Alert alert = driver.switchTo().alert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        return alert.getText();
    }
    public void alertOk(WebDriver driver,Alert alert){
        driver.switchTo().alert();
        alert.accept();
    }

    public String clickConfirm(WebDriver driver) {
        jsConfirm.click();
        Alert alert = driver.switchTo().alert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        String messageAlert = alert.getText();
        return messageAlert;
    }

    public void acceptAlert(Alert alert) {
        alert.accept();
    }

    public void sendMessage(WebDriver driver, String text) {
        jsPromt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String isMessageDisplayed(WebDriver driver) {
        WebElement typedMessage = driver.findElement(By.xpath("//p[@id='result']"));
        return typedMessage.getText();
    }

}
