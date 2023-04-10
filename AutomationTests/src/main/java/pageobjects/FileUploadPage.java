package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FileUploadPage {
	public WebDriver driver;

	public FileUploadPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="file-upload")
	private WebElement chooseFile;

	@FindBy(id="file-submit")
	private WebElement uploadButton;

	@FindBy(xpath="//div/h3")
	private WebElement uploadMessage;

	public String uploadFile(String filename) {
		chooseFile.sendKeys(System.getProperty("user.dir")+"//"+filename);
		uploadButton.click();
		return uploadMessage.getText();
	}

}
