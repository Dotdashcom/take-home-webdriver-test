package module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import configuration.PageLoader;

public class FileDownload {
	
	private WebDriver driver = null;
	
	@FindBy(how=How.LINK_TEXT, using="some-file.txt")
	private WebElement download;
	
	public FileDownload(WebDriver driver) {
		this.driver = driver;
		this.loadPage();
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Click the file link
	 * On Linux + Chrome this is downloading the file
	 * without needing to set additional options.
	 * Mileage may vary on other OS.
	 */
	public void clickDownloadLink() {
		download.click();
	}

	public void loadPage() {
		PageLoader.loadPage(driver, "/download");		
	}
	
}
