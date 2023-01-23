package PageObjects;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractClass;

public class FileDownloadPage extends AbstractClass {
	WebDriver driver;

	public FileDownloadPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href='download/some-file.txt']")
	WebElement filelink;

	public File fileDownload() throws InterruptedException {
		filelink.click();
		Thread.sleep(5000);
		String filepath = "C:\\Users\\Admin\\Downloads\\some-file.txt";
		File file = new File(filepath);
		return file;

	}
}
