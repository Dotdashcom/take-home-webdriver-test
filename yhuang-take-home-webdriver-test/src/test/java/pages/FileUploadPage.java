package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BaseDriver{
	public FileUploadPage(WebDriver driver){
        super(driver);
    }
	
	@FindBy(id ="file-upload")
    public WebElement chooseFileInput;
	
	@FindBy(id ="file-submit")
    public WebElement uploadBtn;
	
	@FindBy(id ="drag-drop-upload")
    public WebElement dragDropArea;
	
	public String uploadFile(String filePath){
		chooseFileInput.sendKeys(filePath);
		uploadBtn.click();
		return driver.findElement(By.id("uploaded-files")).getText();
	}
}
