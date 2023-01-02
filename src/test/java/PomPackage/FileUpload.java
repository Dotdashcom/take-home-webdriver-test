package PomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class FileUpload extends BaseClass{
	@FindBy(xpath = "//input[@value='Upload']")
	public WebElement uploadBtn;

	@FindBy(xpath = "//input[@id='file-upload']")
	public WebElement chooseFileBtn;

	@FindBy(tagName = "h3")
	public WebElement msg;

	public FileUpload() {
		PageFactory.initElements(driver, this);
	}
	

}
