package PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Common.Config;
public class FileUploadPage extends BasePage {
	@FindBy (id = "file-upload")
	WebElement fileUpload;
	@FindBy (id = "file-submit")
	WebElement fileSubmit;
	@FindBy (id = "uploaded-files")
	WebElement successMessage;
	public FileUploadPage (Config testConfig) {
		super(testConfig);
	}
	public void uploadFile(String fileName) {
		fileUpload.sendKeys(fileName);
		fileSubmit.click();
	}
	public String getSuccessMessage() {
		return successMessage.getText();
	}
}
