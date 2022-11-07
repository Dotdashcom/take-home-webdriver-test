package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FileUploaderPage {
	@FindBy(xpath="//input[@id='file-upload']")
	private WebElement searchFilUploader;
	
	@FindBy(xpath="//div[@id='content']//h3")
	private WebElement searchFilUploadMsg;
	
	@FindBy(xpath="//div[@id='drag-drop-upload']")
	private WebElement searchdraganddrop;


	
	public FileUploaderPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void fileuploader() {
		searchFilUploader.sendKeys(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\sample.txt");
	}
	public String gettext() {
	
		return searchFilUploadMsg.getText();
	}
	
	public void draganddrop() {
	 searchdraganddrop.sendKeys("C:\\Users\\chiru\\Desktop\\Sample.txt");
	}
	
	
}
