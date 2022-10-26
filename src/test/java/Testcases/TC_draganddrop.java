package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC_draganddrop {
	@Test
	
	public void test(){
		
		 System.setProperty("Webdriver.chrome.driver","C:\\Users\\GURPREET\\Downloads\\chromedriver_win32k(3)\\chromedriver.exe" );
		 WebDriver driver = new ChromeDriver();
		 String URL = "http://localhost:7080/drag_and_drop";
		 
		 driver.get(URL);
		 
		 
		 Actions builder = new Actions(driver);
		 
		 WebElement from = driver.findElement(By.id("column-a"));
		 WebElement to =  driver.findElement(By.id("column-b"));
		 
		 
		 builder.dragAndDrop(from, to).perform();
		 
		 String textTo = to.getText();
		 if(textTo.equals("Dropped!")) {
			 System.out.println("PASS");
		 }
		 else {
			 System.out.println("FAIL");
		 }
		 driver.close();
		
	}
}
