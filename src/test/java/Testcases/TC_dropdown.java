package Testcases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_dropdown {
	public void testdropdown() {
		
		String URL ="http://localhost:7080/dropdown";
		 System.setProperty("Webdriver.chrome.driver","C:\\Users\\GURPREET\\Downloads\\chromedriver_win32k(3)\\chromedriver.exe" );
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get(URL);
		 
		 WebElement dropdown = driver.findElement(By.id("dropdwon"));
		 Select s1 = new Select(dropdown);
		 
		s1.selectByValue("1");
		s1.deselectByValue("1");
		s1.selectByValue("2");
		
		if(driver.getTitle().equals("The Internet"))
		{
			Assert.assertTrue(true);
			System.out.println(driver.getTitle());
		}
		else
		{
			Assert.assertTrue(false);
		}
		 
		
		 driver.close();
		 
	}

}
