package pageObjectModel;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadPage {
	private WebDriver driver;

	public FileUploadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "file-upload")
	private WebElement chooseFile;

	@FindBy(how = How.ID, using = "file-submit")
	private WebElement uploadButton;

	@FindBy(how = How.CSS, using = "div.example>h3")
	private WebElement uploadMessage;

	public void uploadFile() {
		String fileName = "C:\\Users\\ningy\\Downloads\\some-file.txt";
		chooseFile.sendKeys(fileName);
		uploadButton.click();
	}
	
	public String uploadMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(uploadMessage));
		return uploadMessage.getText();
	}
}
