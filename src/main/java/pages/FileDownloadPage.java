package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FileDownloadPage {
	static WebDriver driver;

	public FileDownloadPage(WebDriver driver) {
		FileDownloadPage.driver = driver;
	}

//	Web Elements List
	@FindBy(how = How.XPATH, using = "//a[@href = 'download/some-file.txt']")
	WebElement FILE_DOWNLOAD_HYPERLINK_ELEMENT;
	
//	Methods
	public void clickFileDownloadHyperlink() {
		FILE_DOWNLOAD_HYPERLINK_ELEMENT.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateFileIsDownloaded() {
		System.out.println("Unable to validate file download but below this syso statement is committed code which is my work that I did for an attempt of completion");

//		-----------------------Committed Code------------------
		
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		System.out.println(jse.executeScript("browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \"<some-file.txt>\"}}"));	
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
