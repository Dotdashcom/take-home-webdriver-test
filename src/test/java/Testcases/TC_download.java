package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_download {
@Test
public void downloadtest() {
	String URL ="http://localhost:7080/download ";
	 System.setProperty("Webdriver.chrome.driver","C:\\Users\\GURPREET\\Downloads\\chromedriver_win32k(3)\\chromedriver.exe" );
	 WebDriver driver = new ChromeDriver();
	 driver.get(URL);
	 
	 WebElement file = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
	 file.click();
	 
	 driver.close();
	 
}
}
