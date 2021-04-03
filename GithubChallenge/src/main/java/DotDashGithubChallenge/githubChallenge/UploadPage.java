package DotDashGithubChallenge.githubChallenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadPage extends TestBase {

	public UploadPage(WebDriver driver) {
		super(driver);
	}

	  @FindBy(id = "file-upload")
	   private WebElement chooseFileBtn;

	  @FindBy(id = "file-submit")
	   private WebElement uploadBtn;

	  @FindBy(id = "drag-drop-upload")
	   private WebElement dragDropUpload;

	  @FindBy(xpath = "//h3[contains(text(), 'File Uploaded')]")
	   private WebElement uploadedMessage;
	  
	  public void uploadFile(String filePath) {
	        chooseFileBtn.sendKeys(filePath);
	        uploadBtn.click();
	    }

	    public boolean verifyUploadSuccessfully() {
	        return uploadedMessage.isDisplayed();
	    }

	    /*
	    private void setClipboardData(String string) {
	        StringSelection stringSelection = new StringSelection(string);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	    }*/
}
