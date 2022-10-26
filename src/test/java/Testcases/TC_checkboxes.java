package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class TC_checkboxes {
@Test
public void checkboxtest(){
	 System.setProperty("Webdriver.chrome.driver","C:\\Users\\GURPREET\\Downloads\\chromedriver_win32k(3)\\chromedriver.exe" );
	 WebDriver driver = new ChromeDriver();
	 
	 String URL = "http://localhost:7080/checkboxes";
	 driver.get(URL);
	 
	 WebElement clickbutton1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
	 clickbutton1.click();
	 System.out.println("first checkbox selected");
	 
	 
	 WebElement clickbutton2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
	 clickbutton2.click();
	 System.out.println("Second Checkbox selected");
	
	 
 driver.quit();
 
}
	
	
}
