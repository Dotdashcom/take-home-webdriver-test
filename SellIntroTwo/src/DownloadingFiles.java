import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class DownloadingFiles {

	@Test
	public static void fileDownloadTest() throws InterruptedException {
		
		
	
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:7080/download");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("some-file.txt")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
