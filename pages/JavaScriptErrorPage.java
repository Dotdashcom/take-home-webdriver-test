package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Util.TestBase;

public class JavaScriptErrorPage extends TestBase {
	
	@FindBy(xpath="//body[@onload='loadError()']")
	WebElement Error;
	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void landingPage() {
		driver.get(BaseUrl+"/javascript_error");
		
	}
	public String verifyError() {
		return Error.getText();
	}
	public void closeBrowser() {
		driver.quit();
	}
}
	
