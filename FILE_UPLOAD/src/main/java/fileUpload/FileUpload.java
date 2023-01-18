package fileUpload;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUpload {

	static String url = "http://localhost:7080/upload ";
	static  WebDriver driver;
    @BeforeTest
	public static void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
    @Test
    public void fileUpload() throws InterruptedException{
    	WebElement element = driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));
		element.sendKeys("C:\\Users\\Owner\\OneDrive\\Pictures\\kigali.jfif");
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();
		
		 if(driver.getPageSource().contains("visionCar.webp")) {
			 System.out.println("File has copmletely uplaoded");
		 }
    	
    }
//    @AfterTest
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	

}
