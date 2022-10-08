package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class DownloadPage extends PageObjectBase{

	public DownloadPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public DownloadPage navigate() {
		super.navigateToRelativeUrl();

		return this;
	}

	public DownloadPage clickFile() {

		WebElement file = this.getDriver().findElement(By.xpath("//div[@class='example']/a"));
		file.click();

		return this;
	}

	public boolean verifyFileWasDownloaded(String path, String fileName) {
		File directory = new File(path);
		File[] directoryContents = directory.listFiles();


		for (int i = 0; i < directoryContents.length; i++) {
			if (directoryContents[i].getName().equals(fileName)) {
				directoryContents[i].delete();
				return true;
			}
		}
		return false;
	}

	@Override
	protected String getRelativeUrl() {
		return "/download";
	}

}
