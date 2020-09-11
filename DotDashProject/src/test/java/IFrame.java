import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrame {
	
		
			@Test	
			public void Frame() {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize(); // to maximize the window
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://localhost:7080/iframe");
	    
		//the is to check even if i scroll down, does the menus still visible or not. 
		//So to perform scroll down i am using javaScrpt executer. 
		 driver.get("http://localhost:7080/iframe");
		 //this will switch to the child frame from thr parent/default frame
		 driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@id='mce_0_ifr']")));
		
	      
	        
	       

	}
	}

		



