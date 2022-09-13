package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Util.TestBase;

public class FileUploadPage extends TestBase{
	
	@FindBy(id="file-upload")
	public static WebElement Upload;
	@FindBy(id="file-submit")
	public static WebElement Submit;
	@FindBy(xpath="//h3[contains(text(),'File Uploaded!')]")
	public static WebElement FileUploaded;
	
	public void Initialization(){
		browserInitialization();
		PageFactory.initElements(driver, this);
	}
	public void landingPage() {
		driver.get(BaseUrl+"/upload");
		
	}
	public void uploadFile() {
		Upload.sendKeys("C:\\Users\\bhavi\\Downloads\\abc.jpg");
		Submit.click();
	}
	public String verifyFile() {
		return FileUploaded.getText();
	}
	public void closeBrowser() {
		driver.quit();
	}
}
