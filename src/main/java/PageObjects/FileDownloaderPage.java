package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownloaderPage {
	@FindBy(xpath="//a[contains(text(),'some-file.txt')]")
	private WebElement searchlink1;
	
	@FindBy(xpath="//a[contains(text(),'Sample.txt')]")
	private WebElement searchlink2;
	
	public FileDownloaderPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void selectsomefile() {
		searchlink1.click();
	}
	public void selectsamplefile() {
		searchlink2.click();
	}


}
