package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.GenericPage;

public class DownloadPage extends GenericPage {

	@FindBy(xpath = "//a[.='some-file.txt']")
	public WebElement downloadFile;
	
	public DownloadPage() {
		PageFactory.initElements(driver, this);
	}
}