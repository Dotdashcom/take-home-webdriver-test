package navpreet.pageobjects;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertsPageObjects {

	WebDriver driver;
	String message,end_result;
	Alert alert;
	
	
	public JavaScriptAlertsPageObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='JavaScript Alerts']")
	private WebElement clickAlerts;
	
	@FindBy(css="button[onclick='jsAlert()']")
	private WebElement jsAlert;
	
	@FindBy(css="button[onclick='jsConfirm()']")
	private WebElement jsConfirm;
	
	@FindBy(css="button[onclick='jsPrompt()']")
	private WebElement jsPrompt;
	
	@FindBy(id="result")
	private WebElement result;
	
	
	
	public void ClickAlert()
	{
		clickAlerts.click();
		ImplicitWait();
	}
	
	public String CheckMessage()
	{
		end_result=result.getText();
		return end_result;
	}
	public void ImplicitWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
	}
	
	public void clickOnJsAlertBtn() {
		jsAlert.click();
	}
	
	public String acceptJsAlert()
	{
		alert=driver.switchTo().alert();
		message=alert.getText();
		alert.accept();
		return message;
	}
	
	public String ClickJsConfirm(String action)
	{
		jsConfirm.click();
		alert=driver.switchTo().alert();
		message=alert.getText();
		if(action.equalsIgnoreCase("ok"))
			alert.accept();
		else if(action.equalsIgnoreCase("cancel"))
			alert.dismiss();
		return message;
	}
	

		public String ClickJSPrompt(String action,String message) {
			jsPrompt.click();
			alert=driver.switchTo().alert();
			if(action.equalsIgnoreCase("ok")) {
				alert.sendKeys(message);
				message=alert.getText();
				alert.accept();
			}
			
			else if(action.equalsIgnoreCase("cancel"))
				alert.dismiss();
			return message;
		}
	
}
