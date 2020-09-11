import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClick {


		@Test	
		public void ContextClick() {

			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();

			driver.get("http://localhost:7080/context_menu");
			driver.manage().window().maximize(); // to maximize the window
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//Using action class to perform mouse function so i can right click it.
			Actions act =  new Actions (driver);
			WebElement element = driver.findElement(By.cssSelector("#hot-spot"));
			act.contextClick(element).perform();//this will open a alert popup
			
			//this will handle the popup
			Alert alert = driver.switchTo().alert();
			alert.accept();
			
			
			
			
		}
}
