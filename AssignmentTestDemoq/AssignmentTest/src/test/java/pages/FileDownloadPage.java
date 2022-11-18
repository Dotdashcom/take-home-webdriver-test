package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FileDownloadPage {
	

	private WebDriver driver;

		public FileDownloadPage(WebDriver driver ) {		
			
			this.driver = driver;
		}
		
		By someFileTextElement = By.cssSelector("a[href*='some']");
		
		public void ClickFile() {
			driver.findElement(someFileTextElement).click();
		}

}
