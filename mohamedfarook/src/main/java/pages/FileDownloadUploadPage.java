package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseClass;

public class FileDownloadUploadPage extends BaseClass {

	@FindBy(xpath = "//a[.='some-file.txt']")
	public WebElement TextFile;

	@FindBy(xpath = "//input[@value='Upload']")
	public WebElement UploadButton;

	@FindBy(xpath = "//input[@id='file-upload']")
	public WebElement chooseFileButton;

	@FindBy(tagName = "h3")
	public WebElement fileUploadedText;

	public FileDownloadUploadPage() {
		PageFactory.initElements(driver, this);
	}

}
