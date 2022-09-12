package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Util.TestBase;

public class FramePage extends TestBase {
	@FindBy(xpath="//iframe[@title='Rich Text Area']")
	WebElement Frame;
	@FindBy(xpath="//body[@id='tinymce']")
	WebElement Write;
	@FindBy(xpath="//body[@id='tinymce']/p")
	WebElement WrittenText;
	
	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void landingPage() {
		driver.get(BaseUrl+"/iframe");
		
	}
	public void switchToFrame() {
		driver.switchTo().frame(Frame);
		Write.clear();
	}
	public String typeAndVerifyText() {
		Write.sendKeys("HappyWorld");
		return WrittenText.getText();
	}
	public void closeBrowser() {
		driver.quit();
	}
	
	
}
