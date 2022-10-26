package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_FileUpload {
@Test

	public void fileupload() {
	String URL ="http://localhost:7080/upload";
	 System.setProperty("Webdriver.chrome.driver","C:\\Users\\GURPREET\\Downloads\\chromedriver_win32k(3)\\chromedriver.exe" );
	 WebDriver driver = new ChromeDriver();
	 driver.get(URL);
	 
	 WebElement choose = driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));
	 choose.sendKeys("C:\\Users\\GURPREET\\Downloads\\some-file.txt");
	 System.out.println("FILE UPLOADED");
	 
	 driver.close();
		
	
		
	}

}
