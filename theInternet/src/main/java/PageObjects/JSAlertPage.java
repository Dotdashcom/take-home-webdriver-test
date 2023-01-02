package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class JSAlertPage {

    WebDriver driver;

    public JSAlertPage(WebDriver driver)
    {

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy( how = How.CSS , using = "button[onclick='jsPrompt()']")
    WebElement JSPrompt;

    @FindBy( how = How.CSS , using = "button[onclick='jsAlert()']")
    WebElement JSAlert;

    @FindBy( how = How.CSS , using = "button[onclick='jsConfirm()']")
    WebElement JSConfirm;



    @FindBy( how = How.CSS , using = " #result")
    WebElement result;

    public void validateAlerts() throws InterruptedException {
        JSAlert.click();
        driver.switchTo().alert().accept();
        JSConfirm.click();
        driver.switchTo().alert().dismiss();
        JSPrompt.click();
        driver.switchTo().alert().sendKeys("abc");
        driver.switchTo().alert().accept();
    }

    public String getResultText(){
        return result.getText();
    }
}
