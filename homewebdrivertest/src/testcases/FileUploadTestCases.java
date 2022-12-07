package testcases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.FileUploadPage;

public class FileUploadTestCases {

	private WebDriver browser;
	
	private FileUploadPage contentPage;
	private String fileExpectedName = "some-file.txt";
	
	@BeforeEach
	public void setup() {
		browser = new ChromeDriver();
		contentPage = new FileUploadPage(browser);
		browser.manage().window().maximize();
		contentPage.goToPage();
	}
	
	@Test
	public void upload_file_button() { 


	}
	

	@Test
	public void upload_file_drag_and_drop() { 


	}
	
	
	@AfterEach
	public void exit() {
		browser.quit();
	}
}
