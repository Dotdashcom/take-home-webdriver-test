package DotDashGithubChallenge.githubChallenge;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownloadPage extends TestBase{

	public DownloadPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@href = 'download/some-file.txt']")
	private WebElement downloadLink;
	
	public void verifyDownload() {
		
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePref = new HashMap<String, Object>();
		chromePref.put("download.default_directory", System.getProperty("java.io.tmpdir"));
		options.setExperimentalOption("prefs", chromePref);
	    driver = new ChromeDriver(options);
	    
	    downloadLink.click();
	    
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    String tmpFolderPath = System.getProperty("java.io.tmpdir");
	    String expectedFileName = "some-file.txt";
	    File file = new File(tmpFolderPath + expectedFileName);
	    if (file.exists())
	    	{
	    	assertEquals(true, file.exists());
	        file.delete();
		
	    	}
	}

}
