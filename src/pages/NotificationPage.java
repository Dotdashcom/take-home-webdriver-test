package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Util.TestBase;

public class NotificationPage extends TestBase {
	@FindBy(xpath="//a[contains(text(),'Click here')]")
	WebElement ClickHere;
	@FindBy(xpath="//div[@id='flash']")
	WebElement Message;
	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void landingPage() {
		driver.get(BaseUrl+"/notification_message_rendered");
		
	}
	public void clickOnButton() {
		ClickHere.click();
	}
	public String verifyMessage() {
		return Message.getText();
	}
	public void closeBrowser() {
		driver.quit();
	}
}
