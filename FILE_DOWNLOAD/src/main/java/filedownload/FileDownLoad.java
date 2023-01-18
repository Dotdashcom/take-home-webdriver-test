package filedownload;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.io.File;
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

public class FileDownLoad {

	static String url = "http://localhost:7080/download";
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
    	WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[2]"));
		element.click();
		
		File files = new File("C:\\Users\\Owner\\Downloads");
		File[]allFiles=files.listFiles();
		for(File file:allFiles) {
			if(file.getName().equals("kigali.jfif")){
				System.out.println("File is downloaded");
			
			}
		}
    }
//    @AfterTest
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	

}
