package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownloadAndUpload {


	WebDriver driver;


	public FileDownloadAndUpload(WebDriver d)
	{
		driver = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(linkText="some-file.txt")
	WebElement file;

	@FindBy(id="file-upload")
	WebElement choosefile;

	@FindBy(xpath="//*[@id=\"file-submit\"]")
	WebElement submitbutton;

	public void FileDownload(){
		driver.get("http://localhost:7080/download");
		file.click();
	}

	 public String FileUpload(){
	        driver.get("http://localhost:7080/upload");
	        choosefile.sendKeys("C:\\nes\\tree-736885__480.jpg");
	        submitbutton.click();
	        String message  = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
	        return message;
	    }
}
