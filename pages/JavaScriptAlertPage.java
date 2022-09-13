package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Util.TestBase;

public class JavaScriptAlertPage extends TestBase {
	
	@FindBy(xpath="//button[@onclick='jsAlert()']")
	WebElement JsAlert;
	@FindBy(xpath="//button[@onclick='jsConfirm()']")
	WebElement JsConfrim;
	@FindBy(xpath="//button[@onclick='jsPrompt()']")
	WebElement JsPrompt;
	@FindBy(xpath="//p[@id='result']")
	WebElement Message;
	
	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void landingPage() {
		driver.get(BaseUrl+"/javascript_alerts");	
	}
	public void clickJsAlert() {
		JsAlert.click();
	}
	public void clickJsConfirm() {
		JsConfrim.click();
	}
	public String verifyMessage() {
		return Message.getText();
	}
	public void clickJsPrompt(String text) {
		JsPrompt.click();
		driver.switchTo().alert().sendKeys(text);	
	}
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	public void closeBrowser() {
		driver.quit();
	}
}
