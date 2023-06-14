import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileDownload {
	public ChromeDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\AssementDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:7080/download");
	}

	@AfterMethod
	public void close() {
		driver.close();
		;
	}
	
	 @Test
	    public void fileDownload() throws InterruptedException {
	     
	        WebElement download = driver.findElement(By.linkText("some-file.txt"));
	        download.click();
	        Thread.sleep(2000);
	        // Downloads

	        File fileLocation = new File("C:\\Users\\HP_001\\Downloads");

	        File [] files = fileLocation.listFiles();
	        boolean downloadedOrNot = false;

	        for (File file : files){
	            if (file.getName().equals("some-file.txt")){
	                System.out.println("File downloaded");
	                downloadedOrNot = true;
	                break;
	            }
	        }
	        Assert.assertTrue(downloadedOrNot, "File not downloaded");
	    }
}
