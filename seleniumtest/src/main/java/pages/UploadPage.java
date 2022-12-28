package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.GenericPage;

public class UploadPage extends GenericPage {
	
	@FindBy(xpath = "//input[@value='Upload']")
	public WebElement uploadButton;

	@FindBy(xpath = "//input[@id='file-upload']")
	public WebElement chooseFileButton;

	@FindBy(tagName = "h3")
	public WebElement message;

	public UploadPage() {
		PageFactory.initElements(driver, this);
	}
}
