import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {
	@Test	
	public void Upload() {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("http://localhost:7080/upload");
		driver.manage().window().maximize(); // to maximize the window
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//you have to use sendKeys here to pass the path you want to upload. 
		 driver.findElement(By.id("file-upload")).sendKeys("/Users/ismailfarouqe/Desktop/Hello dot dash.docx");
		 driver.findElement(By.xpath("//input[@id='file-submit']")).click();
	

	}
}
