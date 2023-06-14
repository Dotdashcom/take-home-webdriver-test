import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {

	private ChromeDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\AssementDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/upload");
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	

	@Test
	public void load() {
		WebElement chooseFile = driver.findElement(By.id("file-upload"));
		chooseFile.sendKeys(System.getProperty("user.home") + File.separator + "Downloads/some-file.txt");
		driver.findElement(By.id("file-submit")).click();
		WebElement content = driver.findElement(By.id("content"));
		assert content.getText().contains("File Uploaded!");
	}
}
