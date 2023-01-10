package Dotdashcom.takehomewebdrivertest.pages;


import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.dotdashcom.takehomewebdrivertest.base.BaseClass;

public class JavaScriptsAlert extends BaseClass {
	@FindBy(linkText = "JavaScript Alerts")
    WebElement javaScriptAlertsButton;

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    WebElement jsAlertButton;

    @FindBy(xpath = "//button[contains(@onclick,'jsConfirm()')]")
    WebElement jsConfirmButton;

    @FindBy(xpath = "//button[contains(@onclick,'jsPrompt()')]")
    WebElement jsPromptButton;

    @FindBy(id = "result")
    WebElement message;
	
	
Actions action = new Actions(driver);
	
	JavascriptExecutor j = (JavascriptExecutor) driver;
	


	public JavaScriptsAlert(){
		PageFactory.initElements(driver, this);
	
	}
	public void clickJavaScriptAlerts(){
        javaScriptAlertsButton.click();
    }
    public void validateJsAlertMsg(WebDriver driver){
        jsAlertButton.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),"I am a JS Alert");
        alert.accept();
    }
    public void validateJsConfirmMsg(WebDriver driver){
        jsConfirmButton.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.accept();
    }
    public void validateJsPrompt(WebDriver driver){
        jsPromptButton.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("amandeep");
        alert.accept();
        Assert.assertEquals(message.getText(),"You entered: amandeep");


    }



}
