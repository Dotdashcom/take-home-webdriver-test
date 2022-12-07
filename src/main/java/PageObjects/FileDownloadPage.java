package PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Common.Config;
public class FileDownloadPage extends BasePage {
	@FindBy (css = "#content > div > a")
	WebElement fileDownloadLink;
	public FileDownloadPage (Config testConfig) {
		super(testConfig);
	}
	public void downloadFile() {
		fileDownloadLink.click();
	}
}
