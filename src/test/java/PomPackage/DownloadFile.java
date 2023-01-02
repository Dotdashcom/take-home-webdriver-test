package PomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class DownloadFile extends BaseClass {
	
	@FindBy(xpath = "//a[.='some-file.txt']")
	public WebElement downloadFile;

	public DownloadFile() {
		PageFactory.initElements(driver, this);
	}

}
