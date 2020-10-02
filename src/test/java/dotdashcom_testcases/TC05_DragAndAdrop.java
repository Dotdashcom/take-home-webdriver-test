package dotdashcom_testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC05_DragAndAdrop {
	public static WebDriver driver;
	
	@BeforeMethod
	public void BrowserInvoking()
	{
		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32_v85//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/drag_and_drop");
		driver.manage().window().maximize();
	}
	
	@Test
	public void drag_and_drop() throws InterruptedException
	{
		
		WebElement element_A =	driver.findElement(By.xpath("//*[@id='column-a']"));
		 
		 WebElement element_B =	driver.findElement(By.xpath("//*[@id='column-b']"));
		Actions dragdrop = new Actions(driver);
		dragdrop.dragAndDrop(element_A, element_B).build().perform();
		Boolean result = element_A.isDisplayed();
		System.out.println(result);
		
		
		//dragdrop.dragAndDrop(element_B, element_A).build().perform();
		//dragdrop.clickAndHold(element_A).build().perform();
		//dragdrop.moveToElement(element_B).build().perform();
		//dragdrop.release(element_B).build().perform();
		//dragdrop.clickAndHold(element_A).moveToElement(element_B).release(element_B).build().perform();
	
		
	}

}
