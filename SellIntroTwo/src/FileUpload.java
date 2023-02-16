import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {

	@Test
	public static void fileUploadTest() {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:7080/upload");
		
		driver.manage().window().maximize();
		
		String path= System.getProperty("user.dir");
		
		driver.findElement(By.id("file-upload")).sendKeys(path + "/Files/OutfitCertificate.pdf");
		

	}

}
