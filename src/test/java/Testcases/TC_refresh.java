package Testcases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_refresh {
	public void testrefresh() {
		
		String URL ="http://localhost:7080/dynamic_content?with_content=static";
		 System.setProperty("Webdriver.chrome.driver","C:\\Users\\GURPREET\\Downloads\\chromedriver_win32k(3)\\chromedriver.exe" );
		 WebDriver driver = new ChromeDriver();
		 driver.get(URL);
		 
		 driver.navigate().refresh();
		 
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
		 driver.close();
	}
	

}
