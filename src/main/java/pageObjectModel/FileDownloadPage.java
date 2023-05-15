package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import org.openqa.selenium.JavascriptExecutor;

public class FileDownloadPage {
	private WebDriver driver;

	public FileDownloadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(how = How.XPATH, using = "//a[contains(text(),'some-file.txt')]")
		private WebElement fileName;
		
		public void downLoadFile() throws InterruptedException {
			fileName.click();
			Thread.sleep(3000);
//			JavascriptExecutor js = (JavascriptExecutor)driver;
//			js.executeScript("arguments[0].click", fileName);		
		}
		
		public boolean isExist() {
			String downloadLocation="C:\\Users\\ningy\\Downloads\\some-file.txt";
			System.out.println(downloadLocation);
			File file=new File(downloadLocation);
			return file.exists();
		}
		
	

}