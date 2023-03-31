package dotDashcom.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownloaderPage {
	WebDriver driver;

	public FileDownloaderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='example']/a")
	private WebElement file;
	
	public void fileDownload() throws AWTException{
		file.click();
		Robot robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	
	public boolean verifyFileDownload() {
		
		String filename=file.getText();
		System.out.println(filename);
		String downloadLocation=System.getProperty("user.dir")+"/Downloads/"+filename;
		File file=new File(downloadLocation);
		return file.exists();
		
		//some-file.txt
	}
}
