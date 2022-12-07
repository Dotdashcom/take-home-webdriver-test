package testcases;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.FileDownloadPage;

public class FileDownloadTestCases {

	private WebDriver browser;
	
	private FileDownloadPage contentPage;
	private String fileExpectedName = "some-file.txt";
	
	@BeforeEach
	public void setup() {
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		browser = new ChromeDriver(options);
		contentPage = new FileDownloadPage(browser);
		browser.manage().window().maximize();
		contentPage.goToPage();
	}
	
	@Test
	public void download_file() { 
		contentPage.downloadFile();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		File folder = new File(System.getProperty("user.dir"));
		File[] listOfFiles = folder.listFiles();
		boolean found = false;
		File f = null;
		     for (File listOfFile : listOfFiles) {
		         if (listOfFile.isFile()) {
		              String fileName = listOfFile.getName();
		               System.out.println("File " + listOfFile.getName());
		               if (fileName.matches("some-file.txt")) {
		                   f = new File(fileName);
		                   found = true;
		                }
		            }
		        }
		assertTrue(found, fileExpectedName);
		f.deleteOnExit();
	}
	
	
	@AfterEach
	public void exit() {
		browser.quit();
	}
}
