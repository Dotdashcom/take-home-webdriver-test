package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DynamicLoading extends Driver {
	

	//Locators
	 
	 public static By StartBtn = By.xpath("//button[contains(text(),'Start')]");
	 public static By HelloWorld = By.xpath("//*[@id='finish']/h4");
	 
	 //WebDriverWait
	 static WebDriverWait wait = new WebDriverWait(Driver.Instance,Duration.ofSeconds(20));


	 // Navigate to Login page
	
	public static void NavigateToDynamicLoadingPage()
	{

		Driver.Instance.get(Baseurl+"//dynamic_loading//2");
		
	}
	
	// Click on Start button
		public static void ClickStartButton()
		{
			Driver.Instance.findElement(StartBtn).click();			
		}
		
		
		// Is Hello World visible
		public static String IsHelloWorldVisible()
		{
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(HelloWorld));
			return Driver.Instance.findElement(HelloWorld).getText();	
		}
	
	
}
