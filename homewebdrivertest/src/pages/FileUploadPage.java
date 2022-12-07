package pages;

import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage{
	
	private String page = "upload";

	public FileUploadPage(WebDriver driver) {
		super(driver);
		setPageUrl(page);
	}
	
	

}
