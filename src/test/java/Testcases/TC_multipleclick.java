package Testcases;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_multipleclick {
	@Test
	public void testmulitpleclick(){
		
		 String URL ="http://localhost:7080/windows";
		 System.setProperty("Webdriver.chrome.driver","C:\\Users\\GURPREET\\Downloads\\chromedriver_win32k(3)\\chromedriver.exe" );
		 WebDriver driver = new ChromeDriver();
		 driver.get(URL);
		 
		 
		 WebElement click  = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
		 click.click();
		 String expected = "Action is unsuccessful, please try again";
		 boolean flag =true;
		 WebElement msg = driver.findElement(By.className("flash notice"));
	
		 
		
		if (msg.getText().equalsIgnoreCase(expected)) {
		   flag = false;
			click.click();
			
					
		}		 
		 Assert.assertTrue(flag,"Action is successful");
	}

}
