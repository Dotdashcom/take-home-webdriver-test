package Testcases;



import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_dynamicload {
	@Test
	public void dynamictest() throws InterruptedException{
		String URL ="http://localhost:7080/dynamic_loading/2";
		 System.setProperty("Webdriver.chrome.driver","C:\\Users\\GURPREET\\Downloads\\chromedriver_win32k(3)\\chromedriver.exe" );
		 WebDriver driver = new ChromeDriver();
		 driver.get(URL);
		 
		 WebElement button = driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
		 button.click();
		 driver.manage().timeouts().getImplicitWaitTimeout();
		 WebElement msg = driver.findElement(By.xpath("//*[@id=\"finish\"]/h4"));
		 boolean imagePresent = msg.isDisplayed();
		
	
		 
		 
		
		 
		 
		
	}

}
