package pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JSAlertsPage {

    public WebDriver driver;

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    public WebElement button_JSAlert;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    public WebElement button_JSConfirm;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    public WebElement button_JSPrompt;

    @FindBy(id = "result")
    public WebElement text_result;

    public JSAlertsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void verifyJSAlertMessages(){
        button_JSAlert.click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(text_result.getAttribute("text").equalsIgnoreCase("You successfuly clicked an alert"),"Alert message not displayed as expected");
        button_JSConfirm.click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(text_result.getAttribute("text").equalsIgnoreCase("You clicked: Ok"),"Confirm Alert message not displayed as expected");
        button_JSPrompt.click();
        Alert alert =driver.switchTo().alert();
        alert.sendKeys("Propmt");
        alert.accept();
        Assert.assertTrue(text_result.getAttribute("text").equalsIgnoreCase("You entered: propmt"),"prompt Alert message not displayed as expected");
    }

}
